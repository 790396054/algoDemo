package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * <a href='https://leetcode.cn/problems/valid-parentheses/description/'>...</a>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 输入：s = '()[]{}'
 * 输出：true
 * 输入：s = '(]'
 * 输出：false
 */
public class IsValid {
    // 1 暴力解法，不断replace匹配的括号 -> ''
    // 2 栈来解决
    public static void main(String[] args) {
        String s = "(){}()()[][][][[]][ ]";
        boolean valid = isValid10(s);
        System.out.println(valid);
    }

    private static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');
    }

    private static boolean isValid10(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValid0(String s) {
        while (!s.isEmpty()) {
            int tmp = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            // 说明没有替换，且字符串长度大于 0。不是有效的括号
            if (tmp == s.length()) {
                return false;
            }
        }
        return true;
    }

    // 方法一：暴力解法
    public static boolean isValid1(String s) {
        while (true) {
            int l = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            // 遍历到所有的括号都被替换完成
            if (s.length() == l) {
                return l == 0;
            }
        }
    }

    // 方法二：最近相关性，用栈解决
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.get(stack.pop()) != c){
                return false;
            }
        }
        return stack.size() == 1;
    }

    // 方法三，栈的另一种写法
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
