package com.leetcode.sort;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 9, 0, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 前面的数字大，交换
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}
