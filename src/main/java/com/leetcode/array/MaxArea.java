package com.leetcode.array;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 11. 盛最多水的容器
 * <a href="https://leetcode.cn/problems/container-with-most-water/">...</a>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class MaxArea {

    public static void main(String[] args) {
//        Map<String, Object> map = new ConcurrentHashMap<>();
//        map.put(null, null);
//        System.out.println(map);
//        String a = "https://aa/a/s/d.png";
//        String[] split = a.split("\\.");
//        System.out.println(split[1]);
//        System.out.println(a.substring(a.lastIndexOf("/") + 1));

        maxArea();
    }

    public static void maxArea() {
        Set<A> a = new HashSet<>();
        boolean add = a.add(new A("a", "b", "c"));
        boolean add1 = a.add(new A("a", "b", "c"));
        boolean add2 = a.add(new A("a", "f", "g"));
        for (A a1 : a) {
            System.out.println(a1);
        }
        System.out.println(add);
        System.out.println(add1);
        System.out.println(add2);
    }

    public static class A {
        public String imgKey;
        public String url;

        public String md5;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return Objects.equals(imgKey, a.imgKey) && Objects.equals(url, a.url) && Objects.equals(md5, a.md5);
        }

        @Override
        public String toString() {
            return "A{" +
                    "imgKey='" + imgKey + '\'' +
                    ", url='" + url + '\'' +
                    ", md5='" + md5 + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(imgKey, url, md5);
        }

        public A(String imgKey, String url, String md5) {
            this.imgKey = imgKey;
            this.url = url;
            this.md5 = md5;
        }
    }
}
