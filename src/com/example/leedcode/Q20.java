package com.example.leedcode;

import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 11:28</pre>
 */
public class Q20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid("][");
        System.out.println(valid);
    }
}

class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                char left = stack.pop();
                if (!jduge(left, c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean jduge(char left, char right) {
        switch (left) {
            case '[':
                return right == ']';
            case '{':
                return right == '}';
            case '(':
                return right == ')';
            default:
                return false;
        }
    }
}

