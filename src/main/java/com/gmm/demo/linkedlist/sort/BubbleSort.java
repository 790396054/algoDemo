package com.gmm.demo.linkedlist.sort;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 8, 9, 0, 4, 5, 6, 7};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true; // 标识有数据交换
                }
            }
            if (!flag) break;
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }
}
