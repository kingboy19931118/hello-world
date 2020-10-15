package com.arbor.leetcode.linked;

/**
 * com.arbor.leetcode.linked.LinkedReverseDemo
 *
 * @author Joem
 * @date 2020-10-13
 * @since v2.0.0
 */
public class LinkedReverseDemo {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(new LinkedReverseDemo().reverseList(root));
        System.out.println(new LinkedReverseDemo().reverseList2(root));
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
         ListNode(int x, ListNode node) { val = x; next = node; }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     "node = " + next + '}';
         }
     }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 1    ->  2   -> 3    -> 4    -> 5    ->  NULL
    * curr
     * ------------------------ while ---------------
     *         next
     *    -> null
     * pre     curr
     * ================================  1->null 2->3->4->5->n
     *                next
     *            ->1
     *         pre    curr
     *         ========================  2->1->null 3->4->5->n
     *                        next
     *                 ->2
     *                 pre    curr
     *                 ================  3->2->1->null 4->5->n
     *                               next
     *                        ->3
     *                        pre    curr
     *                        =========  4->3->2->1->null 5->n
     *                                        next
     *                               ->4
     *                               pre      curr==null
     *                               === 5->4->3->2->1->null n
     * ---------------------------------------------------
     * pre == 5
     * return pre;
     */
}
