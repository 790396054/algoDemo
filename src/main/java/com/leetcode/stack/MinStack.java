package com.leetcode.stack;

import java.util.Map;
import java.util.Stack;

/**
 * 155. 最小栈
 * <a href="https://leetcode.cn/problems/min-stack/description/">...</a>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    // 用 2 个栈来实现。一个栈存放正常的数据，另一个栈存放最小元素的栈
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin(); // -3
        System.out.println("min = " + min);
        minStack.pop();
        int top = minStack.top();//--> 返回 0.
        System.out.println("top = " + top);
        int min1 = minStack.getMin();// --> 返回 -2.
        System.out.println("min1 = " + min1);
    }

    private final Stack<Integer> normalStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        normalStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        normalStack.pop();
        minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
