package com.arbor.leetcode.dynamic;

/**
 * com.arbor.leetcode.dynamic.DynamicDemo
 *
 * https://mp.weixin.qq.com/s/axMa0IxjYfIr18jFjYbyUg
 *
 * @author Joem
 * @date 2020-09-29
 * @since v2.0.0
 */
public class DynamicDemo {

    public static void main(String[] args) throws Exception {
        DynamicDemo dynamicDemo = new DynamicDemo();
        int total = dynamicDemo.caculate(7, 5);
        int ap = dynamicDemo.caculate(3, 3);
        int pb = dynamicDemo.caculate(2, 4);
        System.out.println(total - ap * pb);
    }

    int maxX = 8;
    int maxY = 6;


    public int caculate(int x, int y) throws Exception {

        if (x == 0) {
            return 1;
        }

        if (y == 0) {
            return 1;
        }

        if (x < 0 || y < 0) {
            throw new Exception("数据异常");
        }

        return caculate(x - 1, y) + caculate(x, y - 1);
    }

}
