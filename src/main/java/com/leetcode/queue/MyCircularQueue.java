package com.leetcode.queue;

/**
 * 622. 设计循环队列
 * <a href="https://leetcode.cn/problems/design-circular-queue/">...</a>
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */
public class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(2);
        boolean param_1 = obj.enQueue(10);
        boolean param_11 = obj.enQueue(11);
        boolean param_12 = obj.enQueue(12);
        boolean param_13 = obj.enQueue(13);
        System.out.println("obj.enQueue(12) " + param_1);
        boolean param_2 = obj.deQueue();
        System.out.println("obj.deQueue() " + param_2);
        int param_3 = obj.Front();
        System.out.println("obj.Front() " + param_3);
        int param_4 = obj.Rear();
        System.out.println("obj.Rear() " + param_4);
        boolean param_5 = obj.isEmpty();
        System.out.println("obj.isEmpty() " + param_5);
        boolean param_6 = obj.isFull();
        System.out.println("obj.isFull() " + param_6);
        boolean param_111 = obj.enQueue(111);
    }

    private final int capacity;
    private int front;
    private int rear;
    private final int[] elements;

    public MyCircularQueue(int k) {
        this.capacity = k + 1;
        front = rear = 0;
        elements = new int[capacity];
    }

    // 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    // 获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    // 检查循环队列是否为空。
    public boolean isEmpty() {
        return front == rear;
    }

    // 检查循环队列是否已满。
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }
}
