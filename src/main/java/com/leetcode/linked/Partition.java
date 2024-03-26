package com.leetcode.linked;

import com.leetcode.utils.Utils;

/**
 * 86. 分隔链表
 * <a href="https://leetcode.cn/problems/partition-list/description/">...</a>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Partition {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode node = new ListNode(1, node1);
        ListNodeUtil.printAll(node);
        ListNode partition = partition(node, 3);
        ListNodeUtil.printAll(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        // 新建 2 个链表，一个保存小于 X 的值，一个保存大于等于 X 的值。最后将 2 个链表链接起来
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        // 链接 2 个链表
        small.next = bigDummy.next;
        // 断开最后链表的指向，否则这里可能出现环
        big.next = null;
        return smallDummy.next;
    }
}
