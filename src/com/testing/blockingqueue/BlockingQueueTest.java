package com.testing.blockingqueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author ayorfree
 * @create 2017-04-06-下午9:43
 */

public class BlockingQueueTest {
    private static final int QUEUE_SIZE = 10;
    private static final int SEARCH_TIME = 100;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Directory: ");
        String directory = in.nextLine();
        System.out.print("Enter the keyword: ");
        String keyword = in.nextLine();

        ArrayBlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        Enumeration enumertor = new Enumeration(queue, new File(directory));
        Thread t = new Thread(enumertor);
        t.start();
        for (int i = 0; i < SEARCH_TIME; i++) {
            new Thread(new Search(queue, keyword)).start();
        }
    }
}

class Enumeration implements Runnable {
    private ArrayBlockingQueue<File> queue;
    private File startingDirectory;
    public static final File Dummy = new File("");

    public Enumeration(ArrayBlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    public void run() {
        try {
            enumerator(startingDirectory);
            queue.put(Dummy);
        } catch (InterruptedException e) {

        }
    }

    public void enumerator(File directory) {
        File[] files = directory.listFiles();
        try {
            for (File file :
                    files) {
                if (file.isDirectory()) enumerator(file);
                else queue.put(file);
            }
        } catch (InterruptedException e) {
        }
    }
}

class Search implements Runnable
{
    private ArrayBlockingQueue<File> queue;
    private String keyword;

    public Search(ArrayBlockingQueue<File> queue, String keyword){
        this.queue = queue;
        this.keyword = keyword;
    }

    public void run(){
        try {
            boolean done = false;
            while (!done){
                File file = queue.take();
                if (file == Enumeration.Dummy){
                    queue.put(file);
                    done = true;
                }
                else search(file);
            }
        } catch (InterruptedException e){
            }
    }

    public void search(File file){
        try (Scanner in = new Scanner(file)){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber, line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}