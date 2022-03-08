package com.gmm.demo.linkedlist.str;

/**
 * 验证是否回文字符串 leetcode 125 题
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        // 高层次（主干）逻辑
        // 1. filter out number & char 2. reverse and compare
        String filterString = filterNonNumberAndChar(s);
        return reverseString(filterString).equalsIgnoreCase(filterString);
    }

    private static String reverseString(String filter) {
        return new StringBuilder(filter).reverse().toString();
    }

    private static String filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]", "");
    }
}
