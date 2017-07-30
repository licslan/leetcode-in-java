/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return help(l1, l2, 0);
    }

    private ListNode help(ListNode l1, ListNode l2, int carray) {
        if (l1 == null && l2 == null && carray == 0)
            return null;

        int sum = 0;
        sum = carray + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        // 注意：sum等于10的时候也要进位
        if (sum >= 10) {
            sum -= 10;
            carray = 1;
        } else
            carray = 0;

        ListNode node = new ListNode(sum);
        // 这里要注意l1、l2为null
        node.next = help(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carray);
        return node;
    }
}