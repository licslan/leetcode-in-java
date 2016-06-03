// 借助一个双向列表来随意移动结点
class DListNode {
    int key;
    int value;
    DListNode pre;
    DListNode post;
}

public class LRUCache {
    Map<Integer, DListNode> cache = new HashMap<>();
    int count;
    int capacity;
    DListNode head, tail;// 设头尾两个辅助结点避免边界值null的问题

    // always add the new node right after the head
    private void addNode(DListNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    // remove an existing node from the linked list
    private void removeNode(DListNode node) {
        DListNode preNode = node.pre;
        DListNode postNode = node.post;
        preNode.post = postNode;
        postNode.pre = preNode;
    }

    // move an existing node to the position right after head
    private void moveToHead(DListNode node) {
        removeNode(node);
        addNode(node);
    }

    // pop the tail
    private DListNode popTail() {
        DListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;

        head = new DListNode();
        head.pre = null;

        tail = new DListNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode node = cache.get(key);

        if (node == null)
            return -1;

        // move the node to head if it exists
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        DListNode node = cache.get(key);

        if (node == null) {
            DListNode newNode = new DListNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);
            count++;

            if (count > capacity) {
                DListNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}