package com.arbor.leetcode.one;

/**
 * com.arbor.leetcode.one.Test64
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Joem
 * @date 2020-04-15
 * @since v2.0.0
 */
public class Test64 {

    public static void main(String[] args) {
        System.out.println(new Test64().sumNums(9));
        System.out.println(new Test64().sumNums2(9));
        System.out.println(new Test64().sumNums3(9));
    }


    public int sumNums(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += sumNums(n-1)) > 0;
        return sum;
    }

    public int sumNums2(int n) {
        return n == 0 ? 0 : n + sumNums2(n - 1);
    }

    public int sumNums3(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

}
