package com.gmm.demo.linkedlist.recurv;

import java.util.*;

public class FibDemo {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(fib(10));

//        generate(3, 0, 0, "");
//        System.out.println(list);
//        int[] nums = new int[]{2, 5, 5, 1};
//        System.out.println(Arrays.toString(twoSum2(nums, 10)));

        System.out.println(climbStairs(10));
    }

    // https://leetcode-cn.com/problems/two-sum/
    // 两数之和
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }

    public static int climbStairs2(int n) {
        if (n == 0) return 0;
        int pre = 0, cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int pre = 0, cur = 1;
        for (int i = 0; i < n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // https://leetcode-cn.com/problems/generate-parentheses/
    // 字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    public static void generate(int n, int left, int right, String s) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, s + "(");
        }
        if (right < n && right < left) {
            generate(n, left, right + 1, s + ")");
        }
    }
}
