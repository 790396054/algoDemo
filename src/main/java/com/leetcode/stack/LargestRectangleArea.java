package com.leetcode.stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description/">...</a>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        int area = largestRectangleArea31(heights);
        System.out.println(area);
    }

    public static int largestRectangleArea31 (int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            // 遍历的元素，小于栈顶的元素，计算面积
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 面积 = height * (right - left -1)
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 清空栈中的元素
        while(stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }

        return maxArea;
    }
    public static int largestRectangleArea3(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {// 7 , 3, -1
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }

    // 方法一：暴力求解，左右 2 个指针，向中间逼近，找到最大的面积
    // i -> 0，n-2
    // j -> i+1， n-1
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length - 2; i++) {
            for (int j = i + 1; j < heights.length - 1; j++) {
                int width = j - i;
                int height = Math.min(heights[i], heights[j]);
                maxArea = Math.max(maxArea, width * height);
            }
        }

        return maxArea;
    }
}
