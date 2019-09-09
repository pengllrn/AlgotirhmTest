package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 10:23</pre>
 */
public class Q409 {
}

class Solution409{
    public int longestPalindrome(String s) {
        int palindrome = 0;
        if(s == null || s.length() == 0)
            return palindrome;
        int[] cnts = new int[256];
        for (char c : s.toCharArray()){
            cnts[c]++;
        }
        for (int cnt : cnts){
            palindrome += (cnt / 2) * 2;
        }
        if(palindrome < s.length())
            palindrome++;
        return palindrome;
    }
}
