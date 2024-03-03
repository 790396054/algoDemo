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

        TreeNode tt = tt();
        System.out.println("==中==");
        tt.inOrder(tt);
        System.out.println("==前==");
        tt.preOrder(tt);
        System.out.println("==后==");
        tt.postOrder(tt);
    }

    public static TreeNode tt() {
        TreeNode root = new TreeNode(41);
        TreeNode left1 = new TreeNode(20);
        TreeNode right1 = new TreeNode(65);
        TreeNode left2 = new TreeNode(11);
        TreeNode right2 = new TreeNode(29);
        TreeNode right3 = new TreeNode(32);
        TreeNode left3 = new TreeNode(50);
        TreeNode right4 = new TreeNode(91);
        TreeNode left4 = new TreeNode(72);
        TreeNode right5 = new TreeNode(99);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;

        right2.right = right3;

        right1.left = left3;
        right1.right = right4;

        right4.left = left4;
        right4.right = right5;

        return root;
    }
}
