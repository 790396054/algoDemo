package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的后序遍历
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">...</a>
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode bst = TreeNodeTest.bst();
        List<Integer> list = postorderTraversal(bst);
        System.out.println(list);
        bst.postOrder(bst);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    /**
     * 前序遍历的过程 是 中左右。
     * 将其转化成 中右左。也就是压栈的过程中优先压入左子树，在压入右子树。
     * 然后将这个结果返回来，这里是利用栈的先进后出倒序打印。
     */
    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.empty()) {
            list.add(stack2.pop().val);
        }
    }
}
