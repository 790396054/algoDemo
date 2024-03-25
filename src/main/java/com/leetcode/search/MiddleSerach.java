package com.leetcode.search;

// 二分搜索
public class MiddleSerach {

    public static void main(String[] args) {
        int[] nums = {21, 22, 43, 55, 67, 77, 88, 90, 92, 99};
        int search = search(nums, 707);
        System.out.println(search);
    }

    public static int search(int[] nums, int val) {
        int left = 0;
        int right= nums.length - 1;
        int middle = 0;
        int n = 0;
        while (left <= right) {
            n++;
            middle = (left + right) / 2;
            if (nums[middle] == val) {
                return middle;
            } else if (val > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(n);
        return -1;
    }

}
