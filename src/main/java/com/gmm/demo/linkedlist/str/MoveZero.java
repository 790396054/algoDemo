package com.gmm.demo.linkedlist.str;

import java.util.ArrayList;

/**
 * 移动 0
 * leetcode 283 题
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(nums);
    }

    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        // 标记 0
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                list.add(i);
            }
        }
        // 移动 0
        for (Integer integer : list) {
            int zero = nums[integer];
            if (integer <= nums.length) {
                nums[integer] = nums[integer + 1];
            }

        }
    }
}
