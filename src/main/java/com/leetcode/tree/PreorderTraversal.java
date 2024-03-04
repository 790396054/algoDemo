package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">...</a>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode bst = TreeNodeTest.bst();
        List<Integer> list = preorderTraversal(bst);
        System.out.println(list);
        bst.preOrder(bst);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    // 前序遍历，用栈来模拟递归
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            // 右节点先压栈，左节点后压栈，那么弹出的时候，左节点先弹出。符合前序遍历的特点：根左右
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
