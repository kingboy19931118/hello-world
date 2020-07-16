package com.arbor.leetcode.task;

import com.alibaba.fastjson.JSON;

/**
 * com.arbor.leetcode.task.Test29
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author Joem
 * @date 2020-06-05
 * @since v2.0.0
 */
public class Test29 {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
        int[][] matrix2 = new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}};
        System.out.println(JSON.toJSONString(new Test29().spiralOrder(matrix1)));
        System.out.println(JSON.toJSONString(new Test29().spiralOrder(matrix2)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        if (matrix.length == 1) {
            return matrix[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        return execute(matrix, 0, result);
    }

    public int[] execute(int[][] matrix, int deep, int[] result) {
        // 上

        // 右

        // 下

        // 左
        return result;
    }
}
