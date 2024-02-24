package com.leetcode.array;

import com.leetcode.utils.Utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 189. 轮转数组
 * <a href="https://leetcode.cn/problems/rotate-array/">...</a>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate {

    public static void main(String[] args) throws UnknownHostException {
        int[] arr = {1, 2, 4, 6, 8};
        Utils.printArr(arr);
        rotate2(arr, 3);
        Utils.printArr(arr);
        InetAddress[] allByName = InetAddress.getAllByName("xiaojukeji.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.toString());
        }
    }

    // 三次反转， https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
    // 第一次：整体翻转
    // 第二次：翻转K 分割的前半部分
    // 第三次：翻转 K 分割后半部分
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }


    // 使用多余数组来拷贝
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
