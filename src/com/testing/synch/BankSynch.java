package com.testing.synch;

/**
 * @author ayorfree
 * @create 2017-03-31-下午10:01
 */

public class BankSynch
{
    private static final int NACOUNTS = 100;
    private static final double INITIAL_AMOUNTS = 1000;

    public static void main(String[] args)
    {
        Bank bank = new Bank(NACOUNTS, INITIAL_AMOUNTS);

        for (int i = 0; i <= bank.size(); i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_AMOUNTS);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Bank
{
    private final double[] accounts;

    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from, int to, double amount)
    {
        try {
            while (accounts[from] < amount)
                wait();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f is from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("TotalBalance is %10.2f%n", getTotalBalance());
            notifyAll();
        }
        catch (InterruptedException e)
        {
        }
    }

    public synchronized double getTotalBalance()
    {
        double sum = 0;
        for (double a :
                accounts) {
            sum += a;
        }
        return sum;
    }

    public int size()
    {
        return accounts.length;
    }
}

class TransferRunnable implements Runnable
{
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private final int DELAY = 10;

    public TransferRunnable(Bank bank, int fromAccount, double maxAmount)
    {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.maxAmount = maxAmount;
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
