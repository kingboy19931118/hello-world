package com.arbor.leetcode.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * com.arbor.leetcode.one.Test445
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joem
 * @date 2020-04-14
 * @since v2.0.0
 */
public class Test445 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(new Test445().addTwoNumbers(l1, l2));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Stack<Integer> stackA = getStack(l1);
        Stack<Integer> stackB = getStack(l2);

        List<Integer> result = new ArrayList<>();

        int tmp = 0;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            Integer num1 = stackA.empty() ? 0 : stackA.pop();
            Integer num2 = stackB.empty() ? 0 : stackB.pop();
            result.add((num1 + num2 + tmp) % 10);
            if ((num1 + num2 + tmp) >= 10) {
                tmp = 1;
            } else {
                tmp = 0;
            }
        }

        if (tmp == 1) {
            result.add(tmp);
        }

        ListNode head = new ListNode(result.get(result.size() - 1));
        ListNode currentNode = head;
        for (int i = 1; i < result.size() ; i++) {
            currentNode.next = new ListNode(result.get(result.size() - i - 1));
            currentNode = currentNode.next;
        }
        return head;
    }

    private Stack<Integer> getStack(ListNode l1) {
        Stack<Integer> stackA = new Stack<>();

        ListNode tmp = l1;
        while (tmp != null) {
            stackA.push(tmp.val);
            tmp = tmp.next;
        }
        return stackA;
    }

    /**
     * current 1
     * second 2
     * second.next 3
     *
     *
     * @param current
     * @return
     */
    public ListNode revert(ListNode current) {
        ListNode second = current.next;
        ListNode third = current.next.next;
        if (second.next == null) {
            third = current;
            current.next = null;
        } else {
            current.next = third;

        }

        return revert(second);
    }

    public ListNode getLastNode(ListNode current) {
        if (current.next == null) {

        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next == null) {
                return val + "";
            }
            return val + "-->" + next;
        }
    }
}
