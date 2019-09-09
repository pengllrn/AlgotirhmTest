package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/4 12:37</pre>
 */
public class Q91 {
    public static void main(String[] args) {
        int i = new Solution91().numDecodings("23");
        System.out.println(i);
    }
}

/**
 * 10 20 101 202 119 279
 */
class Solution91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(one == 0){
                if(two == 10 || two == 20)
                    dp[i] = dp[i-2];
                else //00,30
                    return 0;
            }
            else {
                if(two < 10 || two > 26)//01,31
                    dp[i] = dp[i-1];
                else //11
                    dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
