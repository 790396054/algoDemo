package com.leetcode.linked;

/**
 * 234. 回文链表
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">...</a>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode middle = new ListNode(3);
        head.next = node2;
        node2.next = middle;
        middle.next = node3;
//        node3.next = node4;

        boolean palindrome = isPalindrome2(head);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode originHead = copyListNode(head);
        ListNode reversedHead = reverse(head);
        while (reversedHead != null) {
            if (reversedHead.val != originHead.val) return false;
            reversedHead = reversedHead.next;
            originHead = originHead.next;
        }
//        ListNode node = copyListNode(head);
//        while (node != null) {
//            System.out.println(node);
//            node = node.next;
//        }
        return true;
    }

    public static ListNode copyListNode(ListNode head) {
        if (head == null) return null; //null 没必要克隆

        ListNode oldNode = head;
        ListNode newNode = new ListNode(oldNode.val);
        ListNode newHead = newNode; //先记住新链表的头节点，一会返回它

        while (oldNode != null && oldNode.next != null) {
            newNode.next = new ListNode(oldNode.next.val);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return newHead;
    }

    // 反转一半进行比较
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 找到中间节点，并断开
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转右边的链表
        ListNode newHead = slow.next;
        ListNode right = reverse(newHead);

        // 双指正遍历 2 个链表，来比较值是否相等
        ListNode left = head;
        while (right != null) {
            if (right.val != left.val) return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
