package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.leetcode.one.Test56
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-16
 * @since v2.0.0
 */
public class Test56 {

    public static void main(String[] args) {
//        int [][] param = new int[4][2];
//        param[0][0] = 1;
//        param[0][1] = 3;
//        param[1][0] = 2;
//        param[1][1] = 6;
//        param[2][0] = 8;
//        param[2][1] = 10;
//        param[3][0] = 15;
//        param[3][1] = 18;
        int [][] param = JSON.parseObject("[[1,3],[2,6],[8,10],[15,18]]", int[][].class);
//        int [][] param = JSON.parseObject("[[1,3],[9,6],[8,10],[15,18]]", int[][].class);
        System.out.println(JSON.toJSONString(new Test56().merge(param)));
//        System.out.println(JSON.toJSON(new Test56().sort(param)));
    }

    public int[][] merge(int[][] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        arr = sort(arr);
        int[][] tmpResult = new int[arr.length][arr[0].length];
        tmpResult[0][0] = arr[0][0];
        tmpResult[0][1] = arr[0][1];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            int aBegin = tmpResult[index][0];
            int aEnd = tmpResult[index][1];
            int bBegin = arr[i][0];
            int bEnd = arr[i][1];
            if (isIntersect(aBegin, aEnd, bBegin, bEnd)) {
                int min = aBegin < bBegin ? aBegin : bBegin;
                int max = aEnd > bEnd ? aEnd : bEnd;
                tmpResult[index][0] = min;
                tmpResult[index][1] = max;
            } else {
                index++;
                tmpResult[index][0] = arr[i][0];
                tmpResult[index][1] = arr[i][1];
            }
        }

        System.out.println(JSON.toJSON(tmpResult));
        System.out.println(index);
        System.out.println(tmpResult.length);
        int[][] result = new int[index + 1][arr[0].length];
        for (int i = 0; i < index + 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = tmpResult[i][j];
            }
        }
        return result;
    }

    public int[][] sort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][0] > arr[j][0]) {
                    int k = arr[i][0];
                    int n = arr[i][1];
                    arr[i][0] = arr[j][0];
                    arr[i][1] = arr[j][1];
                    arr[j][0] = k;
                    arr[j][1] = n;
                }
            }
        }
        return arr;
    }

    public boolean isIntersect(int aBegin, int aEnd, int bBegin, int bEnd) {
        if (aBegin > bEnd) {
            return false;
        }

        return true;
    }

//    public List<Range> convetRange(int[][] arr) {
//        List<Range> list = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//    }
//
//    class Range {
//        int begin;
//        int end;
//
//        public Range(int begin, int end) {
//            this.begin = begin;
//            this.end = end;
//        }
//    }
}
