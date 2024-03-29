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

    // 找寻可以跳的最远距离

    /**
     * 换句话说，对于每一个可以到达的位置 xx，它使得 x+1, x+2, \cdots, x+\textit{nums}[x]x+1,x+2,⋯,x+nums[x] 这些连续的位置都可以到达。
     *
     * 这样以来，我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 xx，如果它在 最远可以到达的位置 的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x +
     * \textit{nums}[x]x+nums[x] 更新 最远可以到达的位置。
     *
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回 True 作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int most = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= most) {
                most = i + nums[i] > most ? i + nums[i] : most;

                // 超过尾节点
                if (most >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
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
