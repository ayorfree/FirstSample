package com.starfucker_inc.v1ch14.synch;

/**
 * @author ayorfree
 * @create 2017-03-29-上午9:42
 */

class TransferRunnable implements Runnable
{
    private Bank bank;
    private int fromAcount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank bank, int fromAcount, double maxAmount)
    {
        this.bank = bank;
        this.fromAcount = fromAcount;
        this.maxAmount = maxAmount;
    }

    public void run()
    {
        try {
            while (true)
            {
                int toAcount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAcount, toAcount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }

        }
        catch (InterruptedException e)
        {

        }
    }
}
