package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 10:45</pre>
 */
public class Q83 {
}

/**
 * 一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
class Solution83{//非递归：迭代
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        while (cur.next != null){
            ListNode next = cur.next;
            if(cur.val == next.val)
                cur.next = next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}

class SOlution83_2{//递归
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        if(head.val == next.val){
            head.next = next.next;
            next.next = null;
            return deleteDuplicates(head);
        } else
            head.next = deleteDuplicates(next);
        return head;
    }
}
