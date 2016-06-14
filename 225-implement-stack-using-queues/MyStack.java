class MyStack {
    Queue<Integer> queue = new LinkedList<>();// 用linkedlist实现的队列

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++)
            queue.add(queue.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();// 返回且将队头移除
    }

    // Get the top element.
    public int top() {
        return queue.peek();// 返回且不移除队头
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}