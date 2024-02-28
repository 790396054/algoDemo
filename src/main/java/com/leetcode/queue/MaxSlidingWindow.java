package com.leetcode.queue;

import com.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.Map;

/**
 * 239. 滑动窗口最大值
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/">...</a>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {41, 8467, 6334, 6500, 9169, 572};
        int k = 3;
        int[] slidingWindow = maxSlidingWindow3(nums, k);
        Utils.printArr(nums);
        Utils.printArr(slidingWindow);
    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        return nums;
    }

    // 暴力求解，改良版本
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < k + i; j++) {
                res[i] = Math.max(res[i], nums[j]);
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int[] temp = new int[k];
        for (int i = 0; i <= nums.length - k; i++) {
            System.arraycopy(nums, i, temp, 0, k);
            res[i] = maxArr(temp);
        }
        return res;
    }

    public static int maxArr(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}
