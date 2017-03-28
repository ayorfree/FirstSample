package com.starfucker_inc.v1ch14.unsynch;

/**
 * @author ayorfree
 * @create 2017-03-28-下午6:01
 */

public class UnsychBank {
    private static final int NACOUNTS = 100;
    private static final double INITIAL_AMOUNT = 1000;

    public static void main(String[] args)
    {
        Bank bank = new Bank(NACOUNTS, INITIAL_AMOUNT);

        for (int i = 0; i < bank.size(); i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_AMOUNT);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
