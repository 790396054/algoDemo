package com.leetcode.recursion;

/**
 * 50. Pow(x, n)
 * <a href="https://leetcode.cn/problems/powx-n/">...</a>
 * 计算 x 的 n 次方
 */
public class MyPow {
    public static void main(String[] args) {
        int a = 2, b = 10;
        long start = System.currentTimeMillis();
        double pow = Math.pow(a, b);
        long time = System.currentTimeMillis() - start;
        System.out.println(pow);
        System.out.println("系统 API 耗时" + time);

        System.out.println("===============");
        start = System.currentTimeMillis();
        double myPow = myPow2(a, b);
        time = System.currentTimeMillis() - start;
        System.out.println("my API 耗时" + time);
        System.out.println(myPow);
    }

    public static double myPow2(double x, double n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public static double fastPow(double x, double n) {
        if (n == 0) {
            return 1;
        }
        double result = fastPow(x, (int)(n / 2));
        return n % 2 == 0 ? result * result : result * result * x;
    }

    public static double myPow(double x, int n) {
        double result = 1;
        int nums = Math.abs(n);
        for (int i = 0; i < nums; i++) {
            if (n < 0) {
                result /= x;
            } else {
                result *= x;
            }
        }
        return result;
    }
}
