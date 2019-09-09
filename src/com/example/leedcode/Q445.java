package com.example.leedcode;

import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 16:27</pre>
 */
public class Q445 {
}

class Solutoin445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<ListNode> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop().val;
            int y = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode end = ans.next;
            ans.next = new ListNode(sum % 10);
            ans.next.next = end;
        }
        return ans.next;
    }
}
