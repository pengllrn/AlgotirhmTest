package com.example.leedcode2;

/**
 * @author Pengllrn
 * @since <pre>2019/9/3 21:50</pre>
 */
public class Solution160 {

}

class Solutionx160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? p2 : p1.next;
            p2 = p2 == null ? p1 : p2.next;
        }
        return p1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
