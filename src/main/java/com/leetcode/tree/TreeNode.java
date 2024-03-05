package com.leetcode.tree;

import java.util.List;

/**
 * 二叉树结构
 */
public class TreeNode {

    // 前序遍历，根-》左-》右
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("root.val = " + root.val);
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

    // 层序遍历。递归实现，利用了二叉树每一层在数组的位置是固定的数学思想。
    public void levelOrder(TreeNode root, int i, List<Integer> list) {
        if (root == null) {
            return;
        }

        // 解决list 数组越界的问题，先填充为 null
        int length = list.size();
        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        // 二叉树的左节点，在数组中的位置是 2*i，i 从 1 开始
        levelOrder(root.left, 2 * i, list);
        // 二叉树的右节点，在数组中的位置是 2*i+1，i 从 1 开始
        levelOrder(root.right, 2 * i + 1, list);
    }

    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
