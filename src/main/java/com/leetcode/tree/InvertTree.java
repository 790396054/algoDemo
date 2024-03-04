package com.leetcode.tree;

import com.leetcode.utils.Utils;

import java.util.ArrayList;

/**
 * 226. 翻转二叉树
 * <a href="https://leetcode.cn/problems/invert-binary-tree/description/">...</a>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode bst = TreeNodeTest.bst();
        ArrayList<Integer> list = new ArrayList<>();
        bst.levelOrder(bst, 1, list);
        Utils.printList(list);
        // 翻转
//        TreeNode invertTree = invertTree(bst);
//        list.clear();
//        invertTree.levelOrder(invertTree, 1, list);
//        Utils.printList(list);

        TreeNode invertTree2 = invertTree2(bst);
        list.clear();
        invertTree2.levelOrder(invertTree2, 1, list);
        Utils.printList(list);
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
