package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/10 9:30</pre>
 */
public class Q21 {
}

class Solution21{//迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null)
            cur.next = l2;
        if(l2 == null)
            cur.next = l1;
        return head.next;
    }
}
class Solution21_2{//递归
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){//合并两个队列，返回首节点
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
