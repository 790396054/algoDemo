package com.leetcode.recursion;

/**
 * 70. 爬楼梯
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">...</a>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 5;
        int i = climbStairs(n);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    public static int dfs(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        int res = memo[n];
        if (res != 0) {
            return res; // 曾经计算过，直接返回。
        }
        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}
