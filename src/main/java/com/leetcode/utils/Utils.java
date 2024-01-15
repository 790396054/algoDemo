package com.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void printArr(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int i : num) {
            list.add(i);
        }
        System.out.println(list);
    }

    public static void swap(int[] arr, int a, int b) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
