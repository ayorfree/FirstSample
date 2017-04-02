package com.testing.blockingqueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ayorfree
 * @create 2017-04-02-下午6:45
 */

public class BlockingQueueTest {
    private static final int QUEUE_SIZE = 10;
    private static final int SEARCH_TIMES = 100;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your directory: ");
        String directory = in.nextLine();
        System.out.println("Enter your keyword: ");
        String keyword = in.nextLine();

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        Enumeration enumerator = new Enumeration(queue, new File(directory));
        Thread t = new Thread(enumerator);
        t.start();
        for (int i = 0; i < SEARCH_TIMES; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}

class Enumeration implements Runnable
{
    private BlockingQueue<File> queue;
    private File startingdirectory;
    public static final File Dummy = new File("");

    public Enumeration(BlockingQueue<File> queue, File startingdirectory)
    {
        this.queue = queue;
        this.startingdirectory = startingdirectory;
    }

    public void run()
    {
        try {
            enumerator(startingdirectory);
            queue.put(Dummy);
        }
        catch (InterruptedException e)
        {
        }
    }

    public void enumerator(File directory) throws InterruptedException
    {
        File[] files = directory.listFiles();
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
                {
                    queue.put(file);
                    done = true;
                }
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
        try (Scanner in = new Scanner(file)) {
            int lineNumber = 0;
            while (in.hasNextLine())
            {
               lineNumber++;
               String line = in.nextLine();
               if (line.contains(keyword))
                   System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }

}


