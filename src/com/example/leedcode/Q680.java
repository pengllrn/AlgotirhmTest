package com.example.leedcode;

public class Q680 {
    public static void main(String[] args) {
        String s = "abc";
        boolean aba = new Palindrome().validate(s, 0, s.length() - 1, 0);
        boolean result = new Palindrome().validate2(s);
        System.out.println(aba);
        System.out.println(result);
    }
}

/**
 * 验证回文字符串 Ⅱ
 * 注意：abcdcbca删除右边第二c可以变成回文：abcdcba,此时不能删除左边
 */
class Palindrome {

    //k表示删除字符的次数
    public boolean validPalindrome(String s, int k, int i, int j) {
        if (k > 1) return false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return validPalindrome(s, k + 1, i + 1, j) || validPalindrome(s, k + 1, i, j - 1);
            i++;
            j--;
        }
        return true;
    }

    public boolean validate(String s, int left, int right, int k) {
        if (k > 1) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return validate(s, left + 1, right, k + 1) || validate(s, left, right - 1, k + 1);
            left++;
            right--;
        }
        return true;
    }

    public boolean validate2(String s) {
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return validateSub(s, i + 1, j) || validateSub(s, i, j - 1);
        }
        return true;
    }

    private boolean validateSub(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}