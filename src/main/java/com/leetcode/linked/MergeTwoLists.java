package com.leetcode.linked;

/**
 * 21. 合并两个有序链表
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">...</a>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        head1.next = node2;
        node2.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(4);
        head2.next = list2;
        list2.next = list3;

        ListNodeUtil.printAll(head1);
        ListNodeUtil.printAll(head2);

        ListNode listNode = mergeTwoLists(head1, head2);
        ListNodeUtil.printAll(listNode);
    }

    // 方法二：递归
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    // 双指针方法
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;

        return dum.next;
    }
}
