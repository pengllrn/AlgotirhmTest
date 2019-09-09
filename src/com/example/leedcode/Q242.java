package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 10:23</pre>
 */
public class Q242 {
}

class Solution242{
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
