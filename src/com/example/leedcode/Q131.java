package com.example.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131 {
    public static void main(String[] args) {
        List<List<String>> aab = new Solution131().partition("ababab");
        System.out.println(aab);
    }
}

class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ans;
        backtracking(ans, s, new ArrayList<>());
        return ans;
    }

    private void backtracking(List<List<String>> ans, String s, List<String> combine) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {//如果0到i是回文
                combine.add(s.substring(0, i + 1));
                backtracking(ans, s.substring(i + 1), combine);//剩余部分再回溯
                combine.remove(combine.size() - 1);//删除最后一个元素，而非最后一个字符
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
