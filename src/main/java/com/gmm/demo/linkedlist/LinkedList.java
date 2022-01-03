package com.gmm.demo.linkedlist;

/**
 * 1. 单链表反转
 * 2. 链表中环的检测
 */
public class LinkedList {

    public static void main(String[] args) {
        Node a = new Node(1, null);
        Node b = new Node(2, a);
        Node c = new Node(3, b);
        Node d = new Node(4, c);
        Node e = new Node(5, d);
        a.next = e;
//        printAll(e);

//        printAll(reverse(e));

        System.out.println(checkCircle(e));
    }

    // {data:1,Node:0x123}->{data:2,Node:124}
    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 链表中环的检测
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void printAll(Node list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }
}
