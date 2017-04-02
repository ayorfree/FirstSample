package com.testing.blockingqueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Enumeration implements Runnable
{
    private BlockingQueue<File> queue;
    private File startingDirectory;
    public static final File Dummy = new File("");

    public Enumeration(BlockingQueue<File> queue, File startingDirectory)
    {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    public void run()
    {
        try {
            enumerator(startingDirectory);
            queue.put(Dummy);
        }
        catch (InterruptedException e)
        {
        }
    }

    public void enumerator(File diectory) throws InterruptedException
    {
        File[] files = diectory.listFiles();
        for (File file :
                files) {
            if (file.isDirectory()) enumerator(file);
            else queue.put(file);
        }
    }

}

class SearchTask implements Runnable
{
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword)
    {
        this.queue = queue;
        this.keyword = keyword;
    }

    public void run()
    {
        try {
            boolean done = false;
            while (!done)
            {
                File file = queue.take();
                if (file == Enumeration.Dummy)
                    done = true;
                else search(file);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }

    public void search(File file) throws IOException
    {
        try (Scanner in = new Scanner(file)){
            int lineNumber = 0;
            while (in.hasNextLine())
            {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains("keyword"))
                    System.out.printf("%s%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }
}

public class BlockingQueueT
{
    private static final int QUEUE_SIZE = 10;
    private static final int SEARCH_TIME = 100;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String directory = in.nextLine();
        String keyword = in.nextLine();
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

        Enumeration enumerator = new Enumeration(queue, new File(directory));
        Thread t = new Thread(enumerator);
        t.start();

        for (int i = 1; i < SEARCH_TIME; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}




