package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <a href="https://leetcode.cn/problems/generate-parentheses/">...</a>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 15;
        List<String> list = generateParenthesis(n);
        System.out.println(list.size());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    public static void generate(int left, int right, int n, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }

        if (right < left) {
            generate(left, right + 1, n, s + ")", list);
        }
    }

    public static void recursion(int left, int right, int n, String s, List<String> list) {
        // terminate
        if (left == n && right == n) {
            System.out.println(s);
            list.add(s);
            return;
        }
        // process logic
        // drill down
        // 最多可以加n 个左括号
        if (left <= n) {
            recursion(left + 1, right, n, s + "(", list);
        }
        // 最多可以加 left 个右括号,就是说，合法的成对的括号，右括号不能比左括号多。
        if (right < left) {
            recursion(left, right + 1, n, s + ")", list);
        }

        // clear
    }
}
