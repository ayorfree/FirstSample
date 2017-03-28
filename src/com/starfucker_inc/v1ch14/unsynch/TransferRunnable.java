package com.starfucker_inc.v1ch14.unsynch;

/**
 * @author ayorfree
 * @create 2017-03-28-下午5:19
 */

public class TransferRunnable implements Runnable {
    private int fromAccount;
    private double maxAmount;
    private Bank bank;
    private int DELAY = 10;

    public TransferRunnable(Bank b, int from, double max)
    {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run()

    {
        try
        {
            while (true)
            {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        }
        catch (InterruptedException e)
        {

        }

    }
}
