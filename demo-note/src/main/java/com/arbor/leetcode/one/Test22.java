package com.arbor.leetcode.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * com.arbor.leetcode.one.Test22
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-09
 * @since v2.0.0
 */
public class Test22 {

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        String str = "()()()";
        System.out.println(test22.valid(str, 3));
//        System.out.println(test22.generateParenthesis(3));

        List<String> strs = new ArrayList<>();
        test22.generate(3 * 2, 3, "", strs);
        System.out.println(strs.size());
        System.out.println(strs);
    }

    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<>();
        generate(n * 2, n, "", strs);
        System.out.println(strs);
        return strs;
    }

    String left = "(";
    String right = ")";

    public void generate(int current) {
        for (int i = 0; i < current * 2; i++) {

        }
    }


    public void generate(int current, int expect, String str, List<String> result) {
        if (current == 2) {
            str = "()" + str;
            if (valid(str, expect)) {
                result.add(str);
            }
            return;
        }

        if (current == 1) {
            String tmp = "(" + str;
            if (valid(tmp, expect)) {
                result.add(tmp);
            }

            String tmp2 = ")" + str;
            if (valid(tmp2, expect)) {
                result.add(tmp2);
            }

            return;
        }

        if (current == 0) {
            return;
        }

        String strLeft = "(" + str;
        String strRight = ")" + str;

        generate(current - 1, expect, strLeft, result);
        generate(current - 1, expect, strRight, result);
    }

    public boolean valid(String strs, int expect) {
        int sum = 0;
        int left = 0;
        int right = 0;
        for (char str : strs.toCharArray()) {
            if (str == '(') {
                left += 1;
                sum += 1;
            }
            if (str == ')') {
                right += 1;
                sum -= 1;
            }
            if (sum < 0 || left > expect || right > expect) {
                return false;
            }
        }
        if (sum != 0 || left != expect) {
            return false;
        }
        return true;
    }
}
