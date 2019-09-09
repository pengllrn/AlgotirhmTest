package com.example.tengxun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/1 19:54</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//开始人数
        int m = sc.nextInt();//每一轮报数玩家数
        int k = sc.nextInt();//游戏轮数
        int size = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            prev.next = node;
            prev = node;
        }
        prev.next = head;
        int cnt = n;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m - 1; j++) {
                prev = head;
                head = head.next;
            }
            System.out.println(head.idx);
            Node next = head.next;
            prev = head;
            int add = sc.nextInt();
            for (int j = cnt + 1; j <= cnt + add; j++) {
                Node node = new Node(j);
                prev.next = node;
                prev = node;
            }
            prev.next = next;
            cnt += add;
        }
    }

    static class Node {
        int idx;
        Node next;
        public Node(int idx){
            this.idx = idx;
        }
    }
}
