package com.arbor.leetcode.one;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.arbor.leetcode.one.Test105
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-05-22
 * @since v2.0.0
 */
public class Test105 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));
    }

    private static Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * root = preorder[0]
     * build left
     * build right
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = buildRoot(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return root;
    }

    private static TreeNode buildRoot(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {

        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        if (preBegin > preEnd) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int rootValue = preorder[preBegin];
        // 在中序遍历中定位根节点
        Integer inRootIndex = inorderMap.get(rootValue);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(rootValue);
        // 得到左子树中的节点数目
        int leftCount = inRootIndex - inBegin;
        // 递归地构造左子树，并连接到根节点
        root.left = buildRoot(preorder, inorder, preBegin + 1, preBegin + leftCount, inBegin, inRootIndex - 1);
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        // 递归地构造右子树，并连接到根节点
        root.right = buildRoot(preorder, inorder, preBegin + leftCount + 1, preEnd, inRootIndex + 1, inEnd);
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        return root;

    }

    private static TreeNode buildLeft(int[] preorder, int[] inorder, int rootValue, int preBegin) {
        if (preBegin >= preorder.length) {
            return null;
        }



        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("【val=" + val + "】");
            if (left != null) {
                stringBuilder.append("left=" + left);
            }
            if (right != null) {
                stringBuilder.append("rignt=" + right);
            }
            return stringBuilder.toString();
        }
    }
}
