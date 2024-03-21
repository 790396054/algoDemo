package com.leetcode.recursion;

import com.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <a href="https://leetcode.cn/problems/subsets/">...</a>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets2(nums);
        Utils.printList(subsets);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(num);
                result.add(newList);
            }
        }

        return result;
    }

    // 递归
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        dfs(ans, nums, list, index + 1);
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);

        // 删除最后一个添加的元素，否则会影响下一次的调用
        list.remove(list.size() - 1);
    }
}
