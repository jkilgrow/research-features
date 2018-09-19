package com.doterra.research.sandbox;

import java.time.Instant;

/*
 * Just a bit of fun...
 * Calculate the fibbonaci sequence a couple of different ways to see which one is faster...
 */
public class WhatDoesThisButtonDo
{
    public static void main(String[] args)
    {
        int start = 0;
        int end = 40;
        int bigEnd = 1000000;
        WhatDoesThisButtonDo what = new WhatDoesThisButtonDo();

        /*
         * Approach 1: recursion
         * Result: Slow!
         */
        Instant startInstFun = Instant.now();
        for (int i = start ; i < end ; i++)
        {
            int value = what.fun(i);
        }
        Instant stopInstFun = Instant.now();
        long diffFun = stopInstFun.toEpochMilli() - startInstFun.toEpochMilli();
        System.out.println("diffFun: " + diffFun);



        /*
         * Approach 2: Keep track of the previous two values and loop incrementally
         * Result: Fastest
         */
        Instant startInstFibA = Instant.now();
        System.out.println("fibA: " + what.fibA(bigEnd));
        Instant stopInstFibA = Instant.now();
        long diffFibA = stopInstFibA.toEpochMilli() - startInstFibA.toEpochMilli();
        System.out.println("diffFibA: " + diffFibA);



        /*
         * Approach 3: Using a matrix to calculate the values.
         * Result: Fast
         */
        Instant startInstFibB = Instant.now();
        System.out.println("fibB: " + what.fibB(bigEnd));
        Instant stopInstFibB = Instant.now();
        long diffFibB = stopInstFibB.toEpochMilli() - startInstFibB.toEpochMilli();
        System.out.println("diffFibB: " + diffFibB);

    }

    /*
     * 0 1 2 3 4 5 6 7  8  9
     * 0 1 1 2 3 5 8 13 21 34
     */
    public int fun(int num)
    {
        if (num > 1)
        {
            return fun(num - 1) + fun(num - 2);
        }
        return num;
    }

    public long fibA(int n)
    {
        long a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public long fibB(int n)
    {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);

        return F[0][0];
    }

    private void multiply(long F[][], long M[][])
    {
        long x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        long y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        long z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        long w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    private void power(long F[][], int n)
    {
        int i;
        long M[][] = new long[][]{{1,1},{1,0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++)
            multiply(F, M);
    }
}
