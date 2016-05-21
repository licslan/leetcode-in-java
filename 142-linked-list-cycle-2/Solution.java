/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 用2个指针，一个一次走一步，一个一次走两步
// 如果链表中存在环，2个指针必定会相遇，假设在第k步相遇，r为环的大小
// 则有，2k-k=nr，即k=nr
// 假设第一次相遇的点和环的起始点的距离为m
// 找到第一次相遇的点后，将slow指针置为head，fast指针为第一次相遇的位置，之后两指针每次一步
// k-m+pr =r-m+qr，即k=nr，所以上述做法一定成立
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null || fast.next.next == null) return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}