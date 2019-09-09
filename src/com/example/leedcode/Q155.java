package com.example.leedcode;

import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 11:01</pre>
 */
public class Q155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(2);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
    }
}

class MinStack {
    private Stack<Integer> stackMin;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stackMin = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty() || stackMin.peek() >= x)
            stackMin.push(x);
        else
            stackMin.push(stackMin.peek());
    }

    public void pop() {
        stackMin.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}