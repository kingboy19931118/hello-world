package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

/**
 * com.arbor.leetcode.one.Test55
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Joem
 * @date 2020-04-17
 * @since v2.0.0
 */
public class Test55 {
    public static void main(String[] args) {
        int[] nums1 = JSON.parseObject("[2,3,1,1,4]", int[].class);
        int[] nums2 = JSON.parseObject("[3,2,1,0,4]", int[].class);
        int[] nums3 = JSON.parseObject("[2,0]", int[].class);
        int[] nums4 = JSON.parseObject("[2,0,0]", int[].class);
        System.out.println(new Test55().canJump(nums1));
        System.out.println(new Test55().canJump(nums2));
        System.out.println(new Test55().canJump(nums3));
        System.out.println(new Test55().canJump(nums4));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }

            boolean flag = false;
            for (int j = i - 1; j >= 0 ; j--) {
                // 最后一位 则可以满足 前一位 - 当前位数字 >= 差
                if (i == nums.length - 1 && nums[j] - nums[i] >= i - j) {
                    flag = true;
                    break;
                }
                // 前一位-当前位的数字 - 1 小于位置差
                // 例如 3 2 1 0 5  i=3 j=2 1-0-1 <=3-2
                if (nums[j] - nums[i] <= i - j) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return false;
            }
        }

        return true;
    }
}
