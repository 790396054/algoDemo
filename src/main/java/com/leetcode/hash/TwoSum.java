package com.leetcode.hash;

import com.leetcode.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) throws IllegalAccessException {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] result = twoSum(nums, target);
        Utils.printArr(result);
    }

    public static int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalAccessException("未找到元素");
    }
}
