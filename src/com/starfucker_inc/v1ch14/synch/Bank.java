package com.starfucker_inc.v1ch14.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ayorfree
 * @create 2017-03-28-下午8:41
 */

class Bank {
    private final double[] acounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance)
    {
        acounts = new double[n];
        for (int i = 0; i < acounts.length; i++) {
            acounts[i] = initialBalance;
            bankLock = new ReentrantLock();
            sufficientFunds = bankLock.newCondition();
        }
    }

    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();
        try {
            while (acounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            acounts[from] -= amount;
            System.out.printf(" %10.2f is from %d to %d", amount, from, to);
            acounts[to] += amount;
            System.out.printf(" TotalBalance is %10.2f%n.", getTotalBlance());
            sufficientFunds.signalAll();
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBlance()
    {
        bankLock.lock();
        try {
            double sum = 0;

            for (double a :
                acounts) {
                sum += a;
            }
            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }

    public int size()
    {
        return acounts.length;
    }
}
