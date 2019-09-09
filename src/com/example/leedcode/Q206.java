package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 8:14</pre>
 */
public class Q206 {
}

class Solution206 {//迭代法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur.next != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

class Solution206_2{
    public ListNode reverseList(ListNode head){//递归法
        if(head == null || head.next ==null)
            return head;
        ListNode cur = head.next;
        ListNode newHead = reverseList(cur);
        cur.next = head;
        head.next = null;
        return newHead;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


