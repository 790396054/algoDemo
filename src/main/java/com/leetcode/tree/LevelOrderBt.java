package com.leetcode.tree;

import com.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

// 二叉树，层序遍历
public class LevelOrderBt {

    public static void main(String[] args) {
        TreeNode bst = TreeNodeTest.bst();
        List<Integer> list = new ArrayList<>();
        bst.levelOrder(bst, 1, list);
        Utils.printList(list);
    }

}
