package com.leetcode.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static void printArr(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int i : num) {
            list.add(i);
        }
        System.out.println(list);
    }
}
