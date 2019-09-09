package com.example.test;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 16:34</pre>
 */
public class Solutiondhsk {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode dummyHead = new ListNode(pHead.val - 1);
        ListNode cur = pHead;
        ListNode prev = dummyHead;
        ListNode last = dummyHead;
        while(cur != null){
            if(cur.val != last.val){
                if(cur.next == null || cur.next.val != cur.val){
                    prev.next = cur;
                    prev = cur;
                }
            }
            last = cur;
            cur = cur.next;
        }

        prev.next = null;
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        list.next = new ListNode(2);
        list.next.next = new ListNode(2);
        ListNode listNode = new Solutiondhsk().deleteDuplication(list);
        System.out.println();
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}