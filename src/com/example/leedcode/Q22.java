package com.example.leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 21:21</pre>
 */
public class Q22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}

/**
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 */
class Solution22 {
    private int n;

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        this.n = n;
        backtrack(list, "", 0, 0);
        return list;
    }

    private void backtrack(List<String> list, String cur, int left, int right) {
        if (left == n && right == n) {
            list.add(cur);
            return;
        }
        if (left > n || right > n) return;
        backtrack(list, cur + "(", left + 1, right);
        if (left > right) backtrack(list, cur + ")", left, right + 1);
    }
}
