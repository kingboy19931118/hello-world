package com.arbor.leetcode.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * com.arbor.leetcode.one.Test112
 *
 * @author Joem
 * @date 2020-04-09
 * @since v2.0.0
 */
public class Test112 {

    public static void main(String[] args) {
        TreeNode node3_1 = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        TreeNode node3_2 = new TreeNode(13, null, null);
        TreeNode node3_3 = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        TreeNode node2_1 = new TreeNode(4, node3_1, null);
        TreeNode node2_2 = new TreeNode(8, node3_2, node3_3);
        TreeNode treeNode = new TreeNode(5, node2_1, node2_2);

        List<List<Integer>> result = new ArrayList<>();
        sum(treeNode, 22, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    public static void sum(TreeNode node, int expect, int current, List<TreeNode> nodes, List<List<Integer>> result) {
        current += node.val;
        nodes.add(node);
        if (node.left == null && node.right == null && current == expect) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode treeNode : nodes) {
                list.add(treeNode.val);
            }
            result.add(list);
        }

        if (node.left != null) {
            sum(node.left, expect, current, nodes, result);
        }

        if (node.right != null) {
            sum(node.right, expect, current, nodes, result);
        }

        current -= node.val;
        nodes.remove(node);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        System.out.println(sum(root));

        return null;
    }

    public static int sum(List<TreeNode> nodes) {
        int sum = 0;
        for (TreeNode node : nodes) {
            sum += node.val;
        }

        return sum;
    }

    public static int sum(TreeNode root) {
        if (root.left != null) {
            return root.val + sum(root.left);
        }

        if (root.right != null) {
            return root.val + sum(root.right);
        }

        return root.val;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
