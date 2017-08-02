/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // fast节点比slow节点快n步，fast节点为倒数第一个时，slow节点为倒数第n+1个节点
        for (int i = 0; i < n; ++i)
            fast = fast.next;

        // 如果fast跑到了null，说明第第一个节点就是倒数第n个节点。直接返回head.next，否则会空指针异常。
        if (fast == null)
            return head.next;

        // 要删除倒数第n个节点，关键是要找到它的前面一个节点，即倒数第n+1个节点
        // 将fast移动到最后一个节点，fast.next为null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    // 通过在链表头添加一个辅助节点
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;
        for (int i = 0; i < n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        // 这里要你返回的是链表头，不是被删除的节点
        return pre.next;
    }
}