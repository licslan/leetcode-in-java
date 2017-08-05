public class Solution {
    // 递归写法
    public ListNode swapPairs(ListNode head) {
        // 当没有节点或者只有一节节点的时候，不用交换节点，直接返回head
        // 递归的运行过程是先将链表的尾部计算好，再一点点往头部添加，知道添加完为止
        if (head == null || head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;

        return temp;
    }


    // 迭代写法
    public ListNode swapPairs1(ListNode head) {
        // 前置辅助节点，以便后面好返回新的链表头
        ListNode pre = new ListNode(0);
        pre.next = head;

        // 这里跟踪指针从pre节点开始，不是从head节点开始
        for (ListNode curr = pre; curr.next != null && curr.next.next != null; curr = curr.next.next)
            curr.next = swap(curr.next, curr.next.next);

        return pre.next;
    }

    private ListNode swap(ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        return node2;
    }
}