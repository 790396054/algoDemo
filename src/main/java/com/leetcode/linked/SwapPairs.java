package com.leetcode.linked;

/**
 * 24. 两两交换链表中的节点
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">...</a>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = swapPairs(head);
        ListNodeUtil.printAll(listNode);
    }

    // 递归解法
    // https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/7058/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {

        }
        return head;
    }
}
