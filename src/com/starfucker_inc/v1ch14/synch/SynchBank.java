package com.starfucker_inc.v1ch14.synch;

/**
 * @author ayorfree
 * @create 2017-03-29-上午9:49
 */

public class SynchBank
{
    private static final int NACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args)
    {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < bank.size(); i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
