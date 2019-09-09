package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    public static void main(String[] args) {
        List<String> strings = new Solution17().letterCombinations("232");
        System.out.println(strings);
    }
}

class Solution17 {
    private final String[] KEYS = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return ans;
        backtracing(ans,digits,new StringBuilder());
        return ans;
    }

    private void backtracing(List<String> ans, String digits, StringBuilder prefix) {
        if(prefix.length() == digits.length()){//递归到地，或遍历到树的叶子节点
            ans.add(prefix.toString());
            return;
        }
        char number = digits.charAt(prefix.length());
        String button = KEYS[number - '0'];
        for (char c : button.toCharArray()){
            prefix.append(c);
            backtracing(ans,digits,prefix);
            prefix.deleteCharAt(prefix.length() -1);
        }
    }
}
