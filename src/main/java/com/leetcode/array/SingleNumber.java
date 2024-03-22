package com.leetcode.array;

/**
 * 136. 只出现一次的数字
 * <a href="https://leetcode.cn/problems/single-number/">...</a>
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 输入：nums = [2,2,1]
 * 输出：1
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 1, 1};
        int singled = singleNumber(nums);
        System.out.println(singled);
    }

    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}
