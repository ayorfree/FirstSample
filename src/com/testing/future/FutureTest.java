package com.testing.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author ayorfree
 * @create 2017-04-03-下午4:59
 */

public class FutureTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your directory: ");
        String directory = in.nextLine();
        System.out.print("Enter your keyword: ");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();

       try {
           System.out.println(task.get() + "matching files");
       }
       catch (ExecutionException e){
           e.printStackTrace();
       }
       catch (InterruptedException e){
       }
    }
}

class MatchCounter implements Callable<Integer>{
    private File direcotry;
    private String keyword;
    private int count;

    public MatchCounter(File direcotry, String keyword ) {
        this.direcotry = direcotry;
        this.keyword = keyword;
    }

    public Integer call(){
        count = 0;
        ArrayList<Future<Integer>> results = new ArrayList<>();
        try {
            File[] files = direcotry.listFiles();
            for (File file :
                    files) {
                if (file.isDirectory()){
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
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            }
            catch (InterruptedException e) {
            }
            return count;
        }

    public boolean search(File file){
        try {
            try (Scanner in = new Scanner(file)){
                boolean found = false;
                while (!found && in.hasNextLine()){
                    String line = in.nextLine();
                    if (line.contains(keyword))
                        found = true;
                    }
                    return found;
                }
            }
            catch (IOException e){
            return false;
        }
    }
}


