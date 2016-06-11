/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // recursion
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    // iteration
    public ListNode removeElements1(ListNode head, int val) {
        ListNode help = new ListNode(0);
        help.next = head;
        ListNode cur = head, pre = help;
        while (cur != null) {
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = pre.next;
            cur = cur.next;
        }
        return help.next;
    }
}