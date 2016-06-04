/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode helper = new ListNode(0);// new starter of the sorted list
        ListNode cur = head;// the node to be inserted
        ListNode pre = helper;// insert node between pre and pre.next
        ListNode next = null;

        while (cur != null) {
            // 记录当前插入结点的下一个结点，插入时会改变该结点的next属性
            next = cur.next;

            // find the right place to insert
            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;

            // insert node between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;

            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}