package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.Type;

/**
 * com.arbor.leetcode.one.Test11
 *
 * @author Joem
 * @date 2020-04-18
 * @since v2.0.0
 */
public class Test11 {

    public static void main(String[] args) {
        int[] height = JSON.parseObject("[1,8,6,2,5,4,8,3,7]", int[].class);
        int[] height2 = JSON.parseObject("[1,1]", int[].class);
        System.out.println(new Test11().maxArea(height));
        System.out.println(new Test11().maxArea(height2));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length ; j++) {
                int current = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
