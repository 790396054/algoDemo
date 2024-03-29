package com.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <a href="https://leetcode.cn/problems/majority-element/">...</a>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1
 * 输入：nums = [3,2,3]
 * 输出：3

 * 示例 2
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2};
        int majoritied = majorityElement2(nums);
        System.out.println(majoritied);
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, ++count);
                if (map.get(num) > nums.length / 2) {
                    return num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }
}
