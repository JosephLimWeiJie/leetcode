class MinStack {
    Node head;
    Node tail;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;
    }
    
    public void push(int x) {
        if (this.head == null) {
            this.head = new Node(x, x, null);
        } else {
            this.head = new Node(x, Math.min(this.head.min, x), this.head);
        }
    }
    
    public void pop() {
        this.head = this.head.prev;
    }
    
    public int top() {
        return this.head.val;
    }
    
    public int getMin() {
        return this.head.min;
    }
    
    public static class Node {
        int val;
        int min;
        Node prev;
        
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
        
        public Node(int val, int min, Node prev) {
            this.val = val;
            this.min = min;
            this.prev = prev;
        }
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
