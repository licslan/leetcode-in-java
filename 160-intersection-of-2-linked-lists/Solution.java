/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // cycle
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1== null ? headB : cur1.next;
            cur2 = cur2== null ? headA : cur2.next;
        }
        return cur1;
    }

    // a faster but long solution
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++)
                cur1 = cur1.next;
        } else {
            for (int i = 0; i < len2 - len1; i++)
                cur2 = cur2.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // using HashMap，Space O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set1 = new HashSet<>();
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            set1.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (set1.contains(cur2))
                return cur2;
            cur2 = cur2.next;
        }
        return cur1;
    }
}