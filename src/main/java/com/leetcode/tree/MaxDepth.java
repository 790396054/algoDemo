package com.leetcode.tree;

import java.util.Map;

/**
 * 104. 二叉树的最大深度
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">...</a>
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {

    public static void main(String[] args) {
        int depth = maxDepth(bt());
        System.out.println(depth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static TreeNode bt() {
        return TreeNodeTest.bst();
    }
}
