package com.leetcode.array;

import com.leetcode.utils.Utils;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/">...</a>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 6, 6, 6, 0, 0, 0};
        int m = 5;
        int[] nums2 = {3, 5, 7};
        int n = 3;
        Utils.printArr(nums1);
        Utils.printArr(nums2);
        merge0(nums1, m, nums2, n);
        Utils.printArr(nums1);
    }

    public static void merge0(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 把 nums2 的元素按要求插入nums1 中。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m--;
        n--;
        while (n >= 0) {
            // 将 nums1 的元素，较大的元素往后放
            while (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            }
            // 将 nums2 的较大的元素放入到 nums1 中
            nums1[i--] = nums2[n--];
        }
    }
}
