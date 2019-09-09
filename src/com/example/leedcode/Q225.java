package com.example.leedcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 10:44</pre>
 */
public class Q225 {
}

class MyStack {
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}