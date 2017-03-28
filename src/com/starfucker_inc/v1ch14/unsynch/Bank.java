package com.starfucker_inc.v1ch14.unsynch;

/**
 * @author ayorfree
 * @create 2017-03-28-下午5:06
 */

class Bank
{
    private final double[] acounts;

    public Bank(int n, double initialBalance)
    {
        acounts = new double[n];

        for (int i = 0; i < acounts.length; i++) {
            acounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, double amount)
    {
        if (acounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        acounts[from] -= amount;
        System.out.printf(" %10.2f form %d to %d", amount, from, to);
        acounts[to] += amount;
        System.out.printf(" TotalBlance is %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance()
    {
        double sum = 0;

        for (double a :
                acounts) {
            sum += a;
        }
        return sum;
    }

    public int size()
    {
        return acounts.length;
    }
}
