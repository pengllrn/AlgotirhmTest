package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/11 11:01</pre>
 */
public class Q328 {
}

class Solution328{
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenEnd = even;
        ListNode cur = even.next;
        while (cur != null){
            ListNode nextEven = cur.next;
            cur.next = even;
            odd.next = cur;
            evenEnd.next = nextEven;
            odd = cur;
            evenEnd = nextEven;

            if(nextEven == null)
                break;
            else
                cur = nextEven.next;
        }
        return head;
    }
}
