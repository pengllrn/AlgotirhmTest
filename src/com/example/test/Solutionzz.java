package com.example.test;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/7/8 14:09</pre>
 */
public class Solutionzz {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return isMatch(str, pattern);
    }

    private boolean isMatch(char[] str, char[] pattern) {
        int lenS = str.length;
        int lenP = pattern.length;
        if (lenS == 0 || lenP == 0) {
            if (lenS == 0 && lenP == 0)
                return true;
            if (lenP == 0)
                return false;
            else {//pattern.length() != 0
                if (lenP == 1) return false;
                if (pattern[1] != '*') return false;
                return isMatch(str, Arrays.copyOfRange(pattern, 2, pattern.length));
            }
        }
        char a = str[0];//a
        char b = pattern[0];//. .*a a
        boolean secondIss = (lenP > 1) && (pattern[1] == '*');
        if (secondIss) {
            if (a != b && b != '.') {//a .*  a b*
                return isMatch(str, cut(pattern, 2));
            } //a a*
            return isMatch(str, cut(pattern, 2)) ||
                    isMatch(cut(str, 1), cut(pattern, 2)) ||
                    isMatch(cut(str, 1), pattern);
        } else {
            if (a == b || b == '.')
                return isMatch(cut(str, 1), cut(pattern, 1));
        }
        return false;
    }

    private char[] cut(char[] arr, int s) {
        return Arrays.copyOfRange(arr, s, arr.length);
    }

    public static void main(String[] args) {//aa b*a   aa .*
        boolean match = new Solutionzz().match("ab".toCharArray(), "a*".toCharArray());
        System.out.println(match);
        char[] as = new char[19];
        char[] chars = Arrays.copyOfRange(as, 19, 19);
        System.out.println(chars.length);
    }

}
