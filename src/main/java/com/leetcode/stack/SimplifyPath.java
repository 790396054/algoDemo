package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 71. 简化路径
 * <a href="https://leetcode.cn/problems/simplify-path/description/">...</a>
 *  给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *  输入：path = "/home/"
 *  输出："/home"
 *  输入：path = "/a/./b/../../c/"
 *  输出："/c"
 */
public class SimplifyPath {
    public static void main(String[] args) {
//        String path = "/a/./b/../../c/";
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.empty()) {
            return "/";
        }
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}
