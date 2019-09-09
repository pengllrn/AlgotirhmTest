package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 10:50</pre>
 */
public class Q9 {
    public static void main(String[] args) {
        boolean palindrome = new Solution9().isPalindrome(-121);
        System.out.println(palindrome);
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int old = x;
        int newX = 0;
        while (x != 0){
            newX = newX * 10 + x % 10;
            x = x / 10;
        }
        return newX == old;
    }
}
