class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // 找到第k+1个节点（第k+1个节点是null也可以）
        while (curr != null && count < k) {
            curr = curr.next;
            ++count;
        }

        // 当有第k+1个节点（第k+1个节点是null也可以），说明这一组有k个节点，反转这k个节点
        if (count == k) {
            curr = reverseKGroup(curr, k);

            // 反转k个节点需要k次操作
            while (count > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
                
                --count;
            }

            // 在上面的循环中，最后一次循环，head开始指向的是k个节点中的最后一个节点
            // 需要将k个节点中的最后一个作为反转后链表的头结点返回
            head = curr;
        }

        return head;
    }
}