package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 10:27</pre>
 */
public class Q205 {
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        int[] arrS = new int[256];
        int[] arrT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (arrS[cs] != arrT[ct])
                return false;
            arrS[cs] = i + 1;
            arrT[ct] = i + 1;
        }
        return true;
    }
}
