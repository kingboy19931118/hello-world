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
        String[] arr = s.split(" ");
        if (arr.length == 1) {
            return s.trim();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {

            String str = arr[arr.length - i - 1];
            if (str.equals("")) {
                continue;
            }
            sb.append(str);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
