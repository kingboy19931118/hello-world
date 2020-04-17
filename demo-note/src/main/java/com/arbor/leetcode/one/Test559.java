package com.arbor.leetcode.one;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * com.arbor.leetcode.one.Test559
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *     1
 * |  |  |
 * 3  2  4
 * | |
 * 5 6
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-17
 * @since v2.0.0
 */
public class Test559 {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(3, new Node(5), new Node(6)), new Node(2), new Node(4));
        System.out.println(new Test559().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() <= 0) {
            return 1;
        }

        List<Integer> result = new ArrayList<>();
        for (Node child : root.children) {
            result.add(maxDepth(child));
        }

        return result.stream().max(Comparator.comparing(Integer::intValue)).orElse(0) + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public Node(int val, Node ... children) {
            this.val = val;
            this.children = Arrays.asList(children);
        }
    }
}
