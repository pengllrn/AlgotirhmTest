package com.example.leedcode2;

/**
 * @author Pengllrn
 * @since <pre>2019/9/3 22:21</pre>
 */
public class Solution206 {

}
class Solutionx206 {
    public ListNode reverseList(ListNode head) {//递归
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}

class Solutionx206_2 {
    public ListNode reverseList(ListNode head) {//迭代
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}

class Solution206_3 {
    public ListNode reverseList(ListNode head) {//头插
        ListNode newHead = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;

    }
}
