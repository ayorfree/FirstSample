package com.starfucker_inc.v1ch14.synch;

/**
 * @author ayorfree
 * @create 2017-03-29-上午10:16
 */

public class SynchBank
{
    private static final int NACOUNTS = 100;
    private static final double INITIAL_AMOUNTS = 1000;

    public static void main(String[] args)
    {
        Bank bank = new Bank(NACOUNTS, INITIAL_AMOUNTS);

        for (int i = 0; i < bank.size(); i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_AMOUNTS);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
