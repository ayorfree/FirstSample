package com.testing.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author ayorfree
 * @create 2017-04-06-下午10:33
 */

public class FutureTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("ENTER YOUR DIRECTORY: ");
        String dirctory = in.nextLine();
        System.out.print("ENTER YOUR KEYWORD: ");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(dirctory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println(task.get() + "match files");
        }catch (InterruptedException e){
        }catch (ExecutionException e){
            e.printStackTrace();
        }

    }
}

class MatchCounter implements Callable<Integer>
{
    private File startingDirctory;
    private String keyword;
    private int count;

    public MatchCounter(File startingDirctory, String keyword) {
        this.startingDirctory = startingDirctory;
        this.keyword = keyword;
    }

    public Integer call(){
        count = 0;
        try {
            ArrayList<Future<Integer>> results = new ArrayList<>();
            File[] files = startingDirctory.listFiles();
            for (File file :
                    files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }
                else {
                    if (search(file)) count++;
                }

            }
            for (Future<Integer> result :
                    results) {
                try {
                    count += result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException e){

        }catch (IOException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File startingDirctory) throws IOException{
        try (Scanner in = new Scanner(startingDirctory)){
            boolean found = false;
            while (!found && in.hasNextLine()){
                String line = in.nextLine();
                if (line.contains(keyword)){
                    found = true;
                }
            }return found;
        }
    }
}