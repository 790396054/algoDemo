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
        int[] heights = {2, 1};
        int area = largestRectangleArea3(heights);
        System.out.println(area);
    }

    public static int largestRectangleArea3(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            // 遍历的元素，小于栈顶的元素，计算面积
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 面积 = height * (right - left -1)
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 清空栈中的元素
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }

    // 方法一：暴力求解，超出时间限制
    // 如果我们枚举「宽」，我们可以使用两重循环枚举矩形的左右边界以固定宽度 w，此时矩形的高度 h，就是所有包含在内的柱子的「最小高度」，对应的面积为 w×h
    public static int largestRectangleArea1(int[] heights) { // 2, 4
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; ++j) {
                int width = (j - i + 1);
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, width * minHeight);
            }
        }

        return maxArea;
    }

    // 方法二：暴力求解，超出时间限制
    // 如果我们枚举「高」，我们可以使用一重循环枚举某一根柱子，将其固定为矩形的高度 h。随后我们从这跟柱子开始向两侧延伸，直到遇到高度小于 h 的柱子，就确定了矩形的左右边界。如果左右边界之间的宽度为 w，那么对应的面积为 w×h
    public static int largestRectangleArea2(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            // 定义左右 2 个指正
            int left = i;
            int right = i;
            int height = heights[i];

            // 只要左边的比当前高，就可以连续拼接图形
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }

            // 只有右边的比当前高，就可以连续拼接图形
            while (right < heights.length - 1 && heights[right + 1] >= height) {
                right++;
            }

            int width = right - left + 1;
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

}
