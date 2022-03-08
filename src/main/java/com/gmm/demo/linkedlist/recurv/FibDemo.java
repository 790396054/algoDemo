package com.gmm.demo.linkedlist.recurv;

import java.util.ArrayList;
import java.util.List;

public class FibDemo {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
//        System.out.println(fib(10));
        generate(3, 0, 0, "");
        System.out.println(list);
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
