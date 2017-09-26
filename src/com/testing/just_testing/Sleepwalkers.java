package com.testing.just_testing;

import java.util.Scanner;

/**
 * david sylvian inspiration
 * @author ayorfree
 * @create 2017-04-26-下午10:18
 */
public class Sleepwalkers{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("input your fav:");

        switch (in.nextLine()){
            case "01":
                System.out.println("谭帆峰");
                break;
            case "02":
                System.out.println("徐飞");
                break;
            default:
                System.out.println("其他人");
        }
    }
}
