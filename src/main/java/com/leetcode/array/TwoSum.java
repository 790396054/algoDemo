package com.leetcode.array;

import com.leetcode.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 100;
        int[] result = twoSum2(nums, target);
        Utils.printArr(result);
    }

    // 方法 2，hash 缓存，用空间换时间
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (map.containsKey(minus)) {
                result[0] = map.get(minus);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // 2 次遍历，暴力解法
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
