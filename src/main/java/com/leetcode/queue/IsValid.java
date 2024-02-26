package com.leetcode.queue;

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
        String s = "(){}()()[][][][[]]]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    private static final Map<Character, Character> map = new HashMap<>();
    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');
    }

    // 方法一：暴力解法
    public static boolean isValid(String s) {
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
}
