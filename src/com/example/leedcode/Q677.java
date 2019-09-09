package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 16:14</pre>
 */
public class Q677 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("appm", 2);
        System.out.println(mapSum.sum("app"));

    }
}

class MapSum {
    private class Node {
        Node[] child = new Node[26];
        int value;
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if (key == null || key.length() == 0)
            return;
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node temp = cur.child[c - 'a'];
            cur.child[c - 'a'] = temp == null ? new Node() : temp;
            cur = cur.child[c - 'a'];
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node) {
        if (node == null)
            return 0;
        if (prefix.length() != 0)
            return sum(prefix.substring(1), node.child[prefix.charAt(0) - 'a']);
        int sum = node.value;
        for (Node nc : node.child) {
            if (nc == null) continue;
            sum += sum("", nc);
        }
        return sum;
    }
}
