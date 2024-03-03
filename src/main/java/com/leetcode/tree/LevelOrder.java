package com.leetcode.tree;

import com.leetcode.utils.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">...</a>
 */
public class LevelOrder {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node level10 = new Node(2);
        Node level11 = new Node(3);
        Node level12 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(level10);
        list1.add(level11);
        list1.add(level12);
        root.children = list1;

        Node level20 = new Node(5);
        Node level21 = new Node(6);
        List<Node> list2 = new ArrayList<>();
        list2.add(level20);
        list2.add(level21);
        level10.children = list2;

        List<List<Integer>> lists = levelOrder(root);
        Utils.printList(lists);
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                if (curr.children != null) {
                    for (Node child : curr.children) {
                        queue.offer(child);
                    }
                }
            }
            ans.add(level);
        }

        return ans;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }
    }
}
