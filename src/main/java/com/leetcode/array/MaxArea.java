package com.leetcode.array;

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
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea3(arr);
        System.out.println(maxArea);
    }

    // 左右2 个指针，分别逼近，一次遍历即可
    public static int maxArea3(int[] arr) {
        int maxArea = 0;

        for (int left = 0, right = arr.length - 1; left < right;) {
            int minHeight = arr[left] < arr[right] ? arr[left++] : arr[right--];
            int area = (right - left + 1) * minHeight;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static int maxArea2(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                int width = j - i;
                int heigth = Math.min(arr[i], arr[j]);
                int area = width * heigth;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // 暴力解法，2 层循环
    public static int maxArea1(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int width = i - j;
                int heigth = Math.min(arr[i], arr[j]);
                int area = width * heigth;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
