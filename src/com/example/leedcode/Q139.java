package com.example.leedcode;

import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/9 17:03</pre>
 */
public class Q139 {
}

class Solution139{
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null)
            return false;
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1;i<= n;i++){
            for (String word : wordDict){
                int len = word.length();
                if(len <= i && word.equals(s.substring(i - len,i))){
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[n];
    }
}
