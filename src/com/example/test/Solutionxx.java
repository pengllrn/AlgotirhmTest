package com.example.test;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/4 17:34</pre>
 */
public class Solutionxx {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str == null)
            return ans;
        boolean[] marked = new boolean[256];
        backtrack(str, ans, marked, new StringBuilder());
        return ans;
    }

    private void backtrack(String str,ArrayList<String> ans, boolean[] marked,StringBuilder sb){
        if(str.length() == sb.length()){
            ans.add(sb.toString());
        }
        for(int i = 0;i < str.length(); i++){
            char c = str.charAt(i);
            if(marked[c]) continue;
            sb.append(c);
            marked[c] = true;
            backtrack(str, ans, marked, sb);
            marked[c] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> abc = new Solutionxx().Permutation("aaa");
        System.out.println(abc);
    }
}
