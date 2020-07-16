package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.arbor.leetcode.one.Test15
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author Joem
 * @date 2020-06-12
 * @since v2.0.0
 */
public class Test15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        long time = System.currentTimeMillis();
        System.out.println(new Test15().threeSum(nums));
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int c = nums[nums.length  - 1];

            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int third = nums.length - 1;
                while (j < third && b + nums[c] > target) {
                    --third;
                }

                if (b == c) {
                    break;
                }

                if (b + nums[third] == target) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(c);
                    result.add(tmp);
                    break;
                }
            }

        }

        return result;
    }
}
