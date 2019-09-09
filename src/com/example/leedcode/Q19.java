package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 11:05</pre>
 */
public class Q19 {
}

class Solution19{//扫描了两次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;
        int cnt = 1;
        ListNode cur = head;
        while (cur.next != null){
            cnt++;
            cur = cur.next;
        }
        cnt -= n;
        if(cnt < 0)
            return head;
        if(cnt == 0)
            return head.next;
        cur = head;
        ListNode prev = head;
        while (cnt > 1){
            prev = cur;
            cur = cur.next;
            cnt--;
        }
        prev.next = cur.next;
        cur.next = null;
        return head;
    }
}

class Solution19_2{//只扫描一次
    public ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null || n <= 0)
            return head;
        ListNode fast = head;
        while (n-- > 0){
            fast = fast.next;
        }
        if(fast == null)
            return head.next;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
