package com.leetcode.array;

import com.leetcode.utils.Utils;

public class SortArr {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 1, 8, 10, 20, 5};
        Utils.printArr(arr);
        selectSort(arr);
        Utils.printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = 1; j < N - 1; j++) {
//                minIndex = arr[i]
            }
        }
    }
}
