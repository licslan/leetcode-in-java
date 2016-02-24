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
		return jk(l1, l2, 0);
	}

	public static ListNode jk(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;
		int sum = 0;
		sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
		if (sum >= 10) {
			sum = sum - 10;
			carry = 1;
		} else {
			carry = 0;
		}
		ListNode tmp = new ListNode(sum);
		tmp.next = jk(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
		return tmp;
	}
}