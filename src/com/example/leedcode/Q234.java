package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/11 9:24</pre>
 */
public class Q234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        boolean palindrome = new Solution234().isPalindrome(head);
        System.out.println(palindrome);
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int cnt = 1;
        ListNode cur = head.next;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        int n = (cnt + 1) / 2 + 1;
        int i = 1;
        cur = head;
        while (i < n) {
            cur = cur.next;
            i++;
        }
        ListNode prev = cur;
        cur = cur.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        i = 1;
        while (i <= cnt / 2) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
            i++;
        }
        return true;
    }
}