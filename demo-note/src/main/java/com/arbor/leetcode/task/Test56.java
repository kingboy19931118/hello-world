package com.arbor.leetcode.task;

/**
 * com.arbor.leetcode.task.Test56
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Joem
 * @date 2020-04-28
 * @since v2.0.0
 */
public class Test56 {

    public static void main(String[] args) {
        int[] num1 = new int[]{4,1,4,6};
        int[] num2 = new int[]{1,2,10,4,1,4,3,3};
        System.out.println(new Test56().singleNumbers(num1));
        System.out.println(new Test56().singleNumbers(num2));
    }

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] ans = new int[2];
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }

        /**
         * 获取不同的两个数【a和b】，从低位开始到哪一位就开始不同了。
         * 其实这一步只需要找到这两个数不同的一个位就可以，这一位后面（和前面）的数置成0就可以了。
         *   ...0000100000... = 10000...
         *   当然这一位没要求是低位的第一位，是任何一个不同的位置都可以，只不过我们有容易的方法
         *   找到第一个低位数字。
         *   int c = a^b;
         *   lowbit = c & (-c);
         */
        mask &= (-mask);//  ...000100...
        /**
         * 接下来就是用mask与数组中的每个数字取异或运算（⊕）。
         * 数组中的任何一个数跟mask做与运算的时候只有两种结果,
         * 要么为0要么就是mask,
         * 因为mask只有一位是1其他位是0，所以做&运算的时候结果只能是0或者mask。
         * 并且这个等于1的这一位也同时区分了a和b,所以这个数组会被分成两组，并且a和b两个数也被分开到不同的组中。
         */
        for (int num : nums) {
            if ((num & mask) == 0) {
                /**
                 * 这里可以这么理解
                 * a⊕d⊕d = a;
                 */
                ans[0] ^= num;
            } else {
                /**
                 * 这里可以这么理解
                 * b⊕e⊕e = b;
                 */
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
