package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 15:30</pre>
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        ListNode listNode = new Solution24().swapPairs(head);
        System.out.println();
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode ahead = head.next;
        head = ahead;
        while (ahead != null) {
            ListNode temp = prev;
            prev.next = ahead.next;
            ahead.next = prev;
            prev = prev.next;
            ahead = prev != null ? prev.next : null;
            temp.next = ahead != null ? ahead : prev;
        }
        return head;
    }
}
