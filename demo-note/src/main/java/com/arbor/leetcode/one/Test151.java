package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

/**
 * com.arbor.leetcode.one.Test151
 *
 * @author Joem
 * @date 2020-04-10
 * @since v2.0.0
 */
public class Test151 {

    public static void main(String[] args) {
        String str = "      a good   example   ";
        System.out.println(new Test151().reverseWords(str));
    }

    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        s = s.trim();
        String[] arr = s.split(" ");
        if (arr.length == 1) {
            return s.trim();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("str : " + sb);
            String str = arr[arr.length - i - 1];
            if ("".equals(str)) {
                continue;
            }
            sb.append(str);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
