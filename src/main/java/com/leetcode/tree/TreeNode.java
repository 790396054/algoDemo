package com.leetcode.tree;

/**
 * 二叉树结构
 */
public class TreeNode {

    // 前序遍历，根-》左-》右
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("root.val = "+ root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历 左-》根-》右
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("root.val = " + root.val);
            inOrder(root.right);
        }
    }

    // 后续遍历 左-》右-》根
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("root.val = " + root.val);
        }
    }

    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
