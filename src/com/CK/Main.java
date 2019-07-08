package com.CK;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x, n));
    }
}

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double xVal;
        int nVal = 0;
        if (n > 0) {
            xVal = x;
            nVal = n;
        } else {
            xVal = (double) 1 / x;
            nVal = -1 * n;
            if (n == Integer.MIN_VALUE) nVal = Integer.MAX_VALUE - 1;
        }
        double res = 1.0;
        int digit = 0;
        while (nVal > 0) {
            int remainder = nVal % 2;
            if (remainder == 1) res = res * Math.pow(xVal, (int) Math.pow(2, digit)) * (double) remainder;
            nVal = nVal / 2;
            digit++;
        }
        return res;
    }
}