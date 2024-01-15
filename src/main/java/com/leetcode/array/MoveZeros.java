package com.leetcode.array;

import com.leetcode.utils.Utils;

import java.io.*;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @link <a href="https://leetcode.cn/problems/move-zeroes/">...</a>
 */
public class MoveZeros {

    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{0, 1, 0, 3, 12, 0, 222, 22, 1, 0, 3};
        Utils.printArr(nums);
//        moveZeros1(nums);
//        moveZeros2(nums);
        moveZeros3(nums);
        Utils.printArr(nums);
//        char a= 0x47;
//        File file = new File("/Users/didi/Desktop/abc.png");
//        InputStream io = new FileInputStream(file);
//        byte[] b = new byte[100];
//        io.read(b);
//        for (byte b1 : b) {
//            System.out.print(b1);
//        }
//        io.close();

    }

    //    输入: nums = [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    public static void moveZeros1(int[] nums) {
        // 新加一个数组，复制的方法
        int[] newArr = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            if (num != 0) {
                newArr[k] = num;
                k++;
            }
        }
        Utils.printArr(newArr);
    }

    // leetcode 提交解法
    //    输入: nums = [0,1,0,3,12]
    //    输出: [1,3,12,0,0]
    public static void moveZeros2(int[] nums) {
        // 双指针法 ，j 标记不为0 的数值。同时和为0 的数字交换。
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        Utils.printArr(nums);
    }

    public static void moveZeros3(int[] nums) {
        // 双指针法 ，j 标记不为0 的数值。同时和为0 的数字交换。
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        Utils.printArr(nums);
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        Utils.printArr(nums);
    }
}
