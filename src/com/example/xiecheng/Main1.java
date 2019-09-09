package com.example.xiecheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}

class Solution1 {
    static ListNode partition(ListNode head, int m) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = dummyHead;
        ListNode last = new ListNode(0);
        ListNode p2 = last;
        while (head != null) {
            if (head.val <= m){
                p1.next = head;
                p1 = head;
                head = head.next;
                p1.next = null;
            }else {
                p2.next = head;
                p2 = head;
                head = head.next;
                p2.next = null;
            }
        }
        p1.next = last.next;
        return dummyHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}