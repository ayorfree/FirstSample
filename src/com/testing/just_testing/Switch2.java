package com.testing.just_testing;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-04-04-下午8:57
 */

public class Switch2 {
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       System.out.println("Enter your favorite chicken: ");

        switch (in.nextLine()) {
            case "a":
                System.out.println("ohhhhhhhh");
                break;
            case "b":
                System.out.println("shittttttt");
                break;
            default:
                System.out.println("chichcicicicici");
        }
    }
}
