package com.testing.threadPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author ayorfree
 * @create 2017-03-30-上午10:19
 */

public class ThreadPoolTest
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your directory: ");
        String directory = in.nextLine();
        System.out.print("Enter your keyword: ");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try
        {
            System.out.println(result.get() + " matching files.");
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largest pool size=" + largestPoolSize);
    }
}

class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool)
    {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public Integer call()
    {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file :
                    files)
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }
                else
                {
                    if (search(file)) count++;
                }
            for (Future<Integer> result :
                    results)
                try
                {
                count += result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }

        }
        catch (InterruptedException e)
        {
        }
        return count;
    }

    public boolean search(File file)
    {
        try {
            try (Scanner in = new Scanner(file)) {
                boolean found = false;
                while (!found && in.hasNextLine())
                {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        }
        catch (IOException e)
        {
            return false;
        }
    }
}