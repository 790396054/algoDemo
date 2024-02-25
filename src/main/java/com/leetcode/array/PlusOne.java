package com.leetcode.array;

import com.leetcode.utils.Utils;

/**
 * 66. 加一
 * <a href="https://leetcode.cn/problems/plus-one/description/">...</a>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        Utils.printArr(nums);
        int[] plusOne = plusOne(nums);
        Utils.printArr(plusOne);
    }

    // +1 判断是否需要进位，数组的第一位不进位，直接返回，数组的第一位进位(9,99,999,9999 等)，扩大数组的长度，第一位一定是 1
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 加 1 后不为 0，直接返回。
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 数组的第一位发生了进位（如：99，999，999 等）数组的长度需要增加一位，且第一位一定是 1，
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
