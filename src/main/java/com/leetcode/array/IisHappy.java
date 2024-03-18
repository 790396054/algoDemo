package com.leetcode.array;

/**
 * 202. 快乐数
 * <a href="https://leetcode.cn/problems/happy-number/">...</a>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IisHappy {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    // 快慢指针解题，类似于链表是否有环。
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public static int next(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
