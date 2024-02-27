package com.leetcode.stack;

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

    }

    public MinStack() {

    }

    public void push(int val) {

    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }
}
