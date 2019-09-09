package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 15:01</pre>
 */
public class Q208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean ans = trie.search("apple");
        System.out.println(ans);
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}


class Trie {
    private class Node{
        Node[] child = new Node[26];
        boolean isLeaf;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;
        Node cur = root;
        for (int i = 0;i< word.length();i++){
            char c = word.charAt(i);
            Node temp = cur.child[c - 'a'];
            cur.child[c - 'a'] = temp == null ? new Node() : temp;
            cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return true;
        Node cur = root;
        for (char c : word.toCharArray()){
            if(cur.child[c - 'a'] == null) return false;
            cur = cur.child[c - 'a'];
        }
        return cur.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)
            return true;
        Node cur = root;
        for (char c : prefix.toCharArray()){
            if(cur.child[c - 'a'] == null) return false;
            cur = cur.child[c - 'a'];
        }
        return true;
    }
}
