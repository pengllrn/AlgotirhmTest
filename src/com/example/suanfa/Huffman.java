package com.example.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/15 11:05</pre>
 */
public class Huffman {

    private class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;
        boolean isLeaf;

        public Node(char ch, int freq) {//构造叶子节点
            this.ch = ch;
            this.freq = freq;
            isLeaf = true;
        }

        public Node(Node left, Node right, int freq) {//构造父节点
            this.left = left;
            this.right = right;
            this.freq = freq;
            isLeaf = false;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public Map<Character, String> encode(Map<Character, Integer> frequencyForChar) {
        if (frequencyForChar == null || frequencyForChar.size() == 0)
            return null;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (char c : frequencyForChar.keySet()) {
            queue.add(new Node(c, frequencyForChar.get(c)));//添加叶子节点
        }
        while (queue.size() != 1) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            queue.add(new Node(node1, node2, node1.freq + node2.freq));//构造新跟节点
        }
        return encode(queue.poll());//返回跟节点
    }

    private Map<Character, String> encode(Node root) {
        Map<Character, String> encodingForChar = new HashMap<>();
        encode(root, "", encodingForChar);
        return encodingForChar;
    }

    private void encode(Node node, String encoding, Map<Character, String> encodingForChar) {
        if (node.isLeaf) {
            encodingForChar.put(node.ch, encoding);
            return;
        }
        encode(node.left, encoding + "0", encodingForChar);
        encode(node.right, encoding + "1", encodingForChar);
    }
}
