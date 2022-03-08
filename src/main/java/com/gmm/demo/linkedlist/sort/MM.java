package com.gmm.demo.linkedlist.sort;

import java.util.ArrayList;
import java.util.List;

public class MM {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(i+"");
        }
        a.remove("0");
        System.out.println(a.size());
    }
}
