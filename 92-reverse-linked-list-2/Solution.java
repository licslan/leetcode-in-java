/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        n -= m;
        ListNode prenode = new ListNode(0);
        ListNode pre = prenode;
        pre.next = head;
        while (--m != 0)
            pre = pre.next;
        ListNode start = pre.next;
        while (n-- != 0) {
            ListNode p = start.next;
            start.next = p.next;
            p.next = pre.next;
            pre.next = p;
        }
        return prenode.next;
    }
}