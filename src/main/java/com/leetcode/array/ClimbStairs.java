package com.leetcode.array;

/**
 * 70. 爬楼梯
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">...</a>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    // 找最近重复子问题
    // n = 1  1
    // n = 2 1,1 2
    // n = 3 1,1,1 1,2 2,1
    // 推到得到：（上第三级台阶，只能是第二级台阶迈一步，或者第一级台阶迈两步）
    // f(n) = f(n-1) + f(n-2) 著名的斐波那契数列
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;

        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
