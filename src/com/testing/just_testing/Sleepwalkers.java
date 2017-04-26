package com.testing.just_testing;

import java.util.Scanner;

/**
 * david sylvian inspiration
 *
 * @author ayorfree
 * @create 2017-04-26-下午10:18
 */

public class Sleepwalkers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your track number here:");

        switch (in.nextLine()) {
            case "01":
                System.out.println("sleepwalkers");
                break;
            case "02":
                System.out.println("money for all");
                break;
            case "03":
                System.out.println("ballads of a deadman");
                break;
            case "04":
                System.out.println("angels");
                break;
            case "05":
                System.out.println("world citizen");
                break;
            case "06":
                System.out.println("five lines");
                break;
            case "07":
                System.out.println("the day the earth stolen heaven");
                break;
            case "08":
                System.out.println("playground martyrs");
                break;
            case "09":
                System.out.println("exit/delete");
                break;
            default:
                System.out.println("next tracks");
        }
    }
}
