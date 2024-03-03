package com.leetcode;

import com.leetcode.linked.ListNode;
import com.leetcode.linked.ListNodeUtil;

public class GlobalTest {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);
        ListNodeUtil.printAll(node);
        ListNode reversed = reverse2(node);
        ListNodeUtil.printAll(reversed);
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverse1(ListNode head) {
        ListNode pre = null, next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
