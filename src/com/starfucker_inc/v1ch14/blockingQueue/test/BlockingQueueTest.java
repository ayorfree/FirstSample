package com.starfucker_inc.v1ch14.blockingQueue.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ayorfree
 * @create 2017-03-29-下午4:58
 */

public class BlockingQueueTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your directory: ");
        String directory = in.nextLine();
        System.out.print("Enter your keyword: ");
        String keyword = in.nextLine();

        final int QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        EnumerationTask enumerator = new EnumerationTask(queue, new File(directory));
        new Thread(enumerator).start();
        for (int i = 1; i <= SEARCH_THREADS ; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}

class EnumerationTask implements Runnable
{
    public static final File Dummy = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    public EnumerationTask(BlockingQueue queue, File startingDirectory)
    {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    public void run()
    {
        try
        {
            enumerator(startingDirectory);
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
               files ) {
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
        try
        {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == EnumerationTask.Dummy) {
                    queue.put(file);
                    done = true;
                } else search(file);
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
        try(Scanner in = new Scanner(file))
        {
            int lineNumber = 0;
            while (in.hasNextLine())
            {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                System.out.printf("%s:%d:%s%n",file.getPath(), lineNumber, line);
            }
        }
    }
}
