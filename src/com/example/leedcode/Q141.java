package com.example.leedcode;

public class Q141 {
}

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
class HaveCircle {

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        int flag = 0;
        while (fast != null){
            if(fast == slow)
                return true;
            if (flag == 0){
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
            flag = 1 - flag;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
