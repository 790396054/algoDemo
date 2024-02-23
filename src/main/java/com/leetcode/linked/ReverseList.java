package com.leetcode.linked;

/**
 * 206 反转链表
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNodeUtil.printAll(node1);

        ListNode reverseList = reverseList1(node1);
        ListNodeUtil.printAll(reverseList);
    }

    // 链表的操作需要记住三个东西，上一个是谁，我是谁，下一个是谁。
    // 遍历解法
    public static ListNode reverseList1(ListNode head) {
        ListNode curr = head, pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 方法二：递归解法
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
