package com.leetcode.linked;

/**
 * 203. 移除链表元素
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">...</a>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);
        ListNodeUtil.printAll(head1);
        ListNode node = removeElements3(head1, 2);
        ListNodeUtil.printAll(node);
    }

    // 遍历，增加哨兵节点，避免了 if 判断
    public static ListNode removeElements3(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val - 1, head);
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        // 处理头结点
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    // 递归解法
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
