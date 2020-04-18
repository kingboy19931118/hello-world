package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

/**
 * com.arbor.leetcode.one.Test104
 *
 * @author Joem
 * @date 2020-04-17
 * @since v2.0.0
 */
public class Test104 {

    public static void main(String[] args) {
        TreeNode treeNode = JSON.parseObject("[3,9,20,null,null,15,7]", TreeNode.class);
        System.out.println(new Test104().maxDepth(treeNode));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
