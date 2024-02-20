package com.leetcode.linked;

import com.gmm.demo.linkedlist.LinkedList;
import com.gmm.demo.linkedlist.Node;

public class ListNodeUtil {

    public static void printAll(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}
