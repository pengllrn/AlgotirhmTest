package com.example.bytedance;

import java.util.HashMap;

/**
 * @author Pengllrn
 * @since <pre>2019/8/31 13:54</pre>
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1, 1);
        System.out.println(cache.toString());
        cache.put(2, 2);
        System.out.println(cache.toString());
        cache.put(3, 3);
        System.out.println(cache.toString());
        cache.get(2);
        System.out.println(cache.toString());
        cache.put(4, 4);
        System.out.println(cache.toString());
        cache.put(5, 5);
        System.out.println(cache.toString());
        cache.get(1);
        System.out.println(cache.toString());
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            remove(node);
            setHead(node);
        } else {
            node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(node);
            map.put(key, node);
        }
    }

    private void remove(Node node) {
        if (node.next != null) {//node != head
            node.next.pre = node.pre;
        } else {
            head = node.pre;
        }

        if (node.pre != null) {//node != tail
            node.pre.next = node.next;
        } else {
            tail = node.next;
        }
    }

    private void setHead(Node node) {
        node.pre = head;
        node.next = null;
        if (head != null)
            head.next = node;
        head = node;
        if (tail == null)
            tail = node;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node node = tail;
        while (node != null){
            sb.append(node.val).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    private class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
