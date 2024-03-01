package com.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <a href="https://leetcode.cn/problems/valid-anagram/">...</a>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        boolean anagram = isAnagram1(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null ) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        // 先将 s 的字母放入 hash 表中。统计每个字符的个数
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                Integer i = map.get(c);
                if (i > 1) {
                    map.put(c, --i);
                } else {
                    map.remove(c);
                }
            } else {
                map.put(c, 1);
            }
        }
        return map.isEmpty();
    }

    // 暴力求解，先排序，再比较
    public static boolean isAnagram1(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}
