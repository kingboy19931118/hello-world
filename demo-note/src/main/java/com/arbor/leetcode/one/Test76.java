package com.arbor.leetcode.one;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * com.arbor.leetcode.one.Test76
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-05-23
 * @since v2.0.0
 */
public class Test76 {

    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(new Test76().minWindow(source, target));
    }

    private static Map<Character, Character> map;

    public String minWindow(String s, String t) {
        map.put(s.charAt(0), s.charAt(s.length() - 1));
        int begin = 0;
        int end = s.length() - 1;
        char[] chars = t.toCharArray();
        Map<Character, Object> targetCharList = new HashMap<>();
        for (char aChar : chars) {
            targetCharList.put(aChar, null);
        }
        int resultBegin;
        int resultEnd;
        while (begin < end) {
            begin = findLeft(s, targetCharList, begin);
            if (begin == -1) {
                return "";
            }
            end = findRight(s, targetCharList, end);
            if (end == -1) {
                return "";
            }

            resultBegin = begin;
            resultEnd = end;
        }


        return "";
    }

    private int findRight(String s, Map<Character, Object> targetCharList, int end) {
        while (end >= 0) {
            if (targetCharList.containsKey(s.charAt(end))) {
                return end;
            }
            end--;
        }

        return -1;
    }

    private int findLeft(String s, Map<Character, Object> t, int begin) {
        while (begin <= s.length() - 1) {
            if (t.containsKey(s.charAt(begin))) {
                return begin;
            }
            begin++;
        }

        return -1;
    }
}
