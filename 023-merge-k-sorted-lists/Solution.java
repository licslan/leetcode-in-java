public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 这个数组有可能为null或者数组长度为0
        if (lists == null || lists.length == 0)
            return null;

        // 使用优先队列，重写比较节点大小的方法
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val < node2.val)
                    return -1;
                else if (node1.val == node2.val)
                    return 0;
                else
                    return 1;
            }
        });

        // 辅助前置节点，以便后面返回首节点
        ListNode pre = new ListNode(0);
        ListNode curr = pre;

        // 将k个链表的首节点加入到优先队列里面去
        for (ListNode node : lists)
            if (node != null)
                queue.add(node);


        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;

            // 这里的两个，一定要注意是node.next，不是node
            if (node.next != null)
                queue.add(node.next);
        }

        return pre.next;
    }
}