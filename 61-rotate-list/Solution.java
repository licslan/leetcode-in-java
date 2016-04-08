/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode auxNode = new ListNode(0);// 辅助结点
		auxNode.next = head;
		ListNode fast = auxNode;
		ListNode slow = auxNode;

		int len = 0;
		for (; fast.next != null; len++)// get total length
			fast = fast.next;
		for (int j = len - k % len; j > 0; j--)// get len-k th node
			slow = slow.next;

		fast.next = auxNode.next;
		auxNode.next = slow.next;
		slow.next = null;
		return auxNode.next;
	}
}
