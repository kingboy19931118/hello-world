package com.arbor.leetcode.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.leetcode.one.Test199
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-22
 * @since v2.0.0
 */
public class Test199 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }

        public TreeNode() {
        }



        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
//        TreeNode treeNode = JSON.parseObject("[1,2,3,null,5,null,4]", TreeNode.class);
        System.out.println(new Test199().rightSideView(root));
        System.out.println(new Test199().rightSideView(root2));
    }

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        execute(root, result);
        return result;
    }

    private void execute(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) {
            return;
        }

        integers.add(root.val);

        if (root.right != null) {
            execute(root.right, integers);
            return;
        }

        if (root.left != null) {
            execute(root.left, integers);
        }
    }


}
