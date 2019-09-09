package com.example.leedcode;

public class Q647 {
    public static void main(String[] args) {
        int i = new Huiwen().countSubstrings("7dh&sjss");
        System.out.println(i);
    }
}

/**
 * 回文子串数
 */
class Huiwen {
    private int cnt = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//以自身为中心拓展
            count(s, i, i + 1);//以连续两个字符为中心扩展
        }
        return cnt;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            cnt++;
            start--;
            end++;
        }
    }
}

class Solution647 {
    private int cnt;

    public int countSubString(String s) {
        if (s == null || s.length() == 0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return cnt;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}