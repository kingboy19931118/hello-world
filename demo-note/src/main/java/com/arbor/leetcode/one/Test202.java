package com.arbor.leetcode.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * com.arbor.leetcode.one.Test2020
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *  
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-30
 * @since v2.0.0
 */
public class Test202 {

    public static void main(String[] args) {
        System.out.println(new Test202().isHappy(19));
        System.out.println(new Test202().isHappy2(19));
    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int tmp = n;
        for (int i = 0; i < 10; i++) {
            int[] split = split(tmp);
            int exec = exec(split);
            if (exec == 1) {
                return true;
            }
            tmp = exec;
        }

        return false;

    }

    public int exec(int... n) {
        int sum = 0;
        for (int i : n) {
            sum = sum + i * i;
        }

        return sum;
    }

    public int[] split(int n) {
        if (n < 10) {

        }

        int tmp = n;
        List<Integer> arr = new ArrayList<>();
        while (tmp > 0) {
            arr.add(tmp % 10);
            tmp /= 10;
        }

        int[] splits = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            splits[i] = arr.get(i);
        }
        return splits;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * 环，若遇到环，则终止 一定不满足.
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }



}
