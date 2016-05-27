public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();// 辅助栈，其栈顶为最小元素

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();// peek the top element of the stack without removing it
            if (x <= min)// 这个地方不能是小于！！！
                minStack.push(x);
        } else
            minStack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (!minStack.isEmpty()) {
            if (x == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */