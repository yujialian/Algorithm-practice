class MinStack {
    Stack<Long> stack;
    long min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            long curr = (long) (x - min);
            if(curr < 0) {
                min = x;
                stack.push(curr);
            } else {
                stack.push(curr);
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        long cur = stack.pop();
        if(cur < 0) {
            min = (min - cur);
        }
    }

    public int top() {
        if(stack.peek() < 0) {
            return (int) min;
        }
        return (int) (min + stack.peek());
    }

    public int getMin() {
        return (int) min;
    }
}
