package com.leetcode.tree;

/**
 * 111. 二叉树的最小深度
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">...</a>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {
    public static void main(String[] args) {
        System.out.println(minDepth(TreeNodeTest.bst()));
        System.out.println(minDepth1(TreeNodeTest.bst()));
    }

    public static int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        // left =0 || right=0 说明，到了左或右 的最深处。取当前的层数 + 1（当前的1 层）
        if (left == 0 || right == 0) return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
