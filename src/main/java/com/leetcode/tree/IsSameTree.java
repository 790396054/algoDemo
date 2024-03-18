package com.leetcode.tree;

/**
 * 100. 相同的树
 * <a href="https://leetcode.cn/problems/same-tree/description/">...</a>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p2 = new TreeNode(2, null, null);
        TreeNode p3 = new TreeNode(3, null, null);
        TreeNode p1 = new TreeNode(1, p2, p3);

        TreeNode q2 = new TreeNode(2, null, null);
        TreeNode q3 = new TreeNode(3, null, null);
        TreeNode q1 = new TreeNode(1, q2, q3);

        boolean sameTree = isSameTree(p1, q1);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
