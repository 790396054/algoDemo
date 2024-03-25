package com.leetcode.sort;

import java.util.*;

// 快排--二分实现
public class QuickSort {

    public static void main(String[] args) {

    }

    public static int[] quickSort(int[] nums) {
        if (nums.length < 2) return nums;

        int flag = nums[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (flag > nums[i]) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }
//        System.arraycopy(quickSort(), 0, nums, 0, 1);
        return nums;
    }
}
