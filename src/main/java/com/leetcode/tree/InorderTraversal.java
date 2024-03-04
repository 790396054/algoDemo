package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">...</a>
 * 给你二叉树的根节点 root ，返回它节点值的 中序 遍历。
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode bst = TreeNodeTest.bst();
        List<Integer> list = inorderTraversal(bst);
        System.out.println(list);
        bst.inOrder(bst);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    // 中序遍历，用栈来模拟递归
    // 尽可能的将这个节点的左子树压入 Stack，此时栈顶的元素是最左侧的元素，其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，并且在寻找的过程中记录了来源，才能返回上层,同时在返回上层的时候已经处理完毕左子树了。。
    // 当处理完最小单位的子树时，返回到上层处理了中间节点。（如果把整个左中右的遍历都理解成子树的话，就是处理完 左子树->中间(就是一个节点)->右子树）
    // 如果有右节点，其也要进行中序遍历。
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                curr = node.right;
            }
        }
    }
}
