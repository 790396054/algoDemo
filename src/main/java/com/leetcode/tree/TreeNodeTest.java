package com.leetcode.tree;

public class TreeNodeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;

        System.out.println("===前序遍历 根 左 右===");
        root.preOrder(root);

        System.out.println("===中序遍历 左 根 右===");
        root.inOrder(root);

        System.out.println("===后续遍历 左 右 根===");
        root.postOrder(root);

        TreeNode tt = bst();
        System.out.println("==中==");
        tt.inOrder(tt);
        System.out.println("==前==");
        tt.preOrder(tt);
        System.out.println("==后==");
        tt.postOrder(tt);
    }

    /**
     *
     *
     *
     *
     */
    public static TreeNode bst() {
        TreeNode left2 = new TreeNode(11);
        TreeNode right3 = new TreeNode(32);
        TreeNode left3 = new TreeNode(50);
        TreeNode left4 = new TreeNode(72);
        TreeNode right5 = new TreeNode(99);

        TreeNode right4 = new TreeNode(91, left4, right5);
        TreeNode right1 = new TreeNode(65, left3, right4);
        TreeNode right2 = new TreeNode(29, null, right3);
        TreeNode left1 = new TreeNode(20, left2, right2);
        TreeNode root = new TreeNode(41,left1, right1);

        return root;
    }
}
