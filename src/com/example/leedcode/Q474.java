package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/9 11:26</pre>
 */
public class Q474 {
    public static void main(String[] args) {
        int maxForm = new Solution474().findMaxForm(new String[]{"0","00","1"}, 1, 0);
        System.out.println(maxForm);
    }
}

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0)
            return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            int zeros = 0,ones = 0;
            for (char c : str.toCharArray()){
                if(c == '0')
                    zeros++;
                else
                    ones++;
            }
            for (int i = m;i>=zeros;i--){
                for (int j = n;j >=ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
