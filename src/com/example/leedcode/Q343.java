package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/4 10:27</pre>
 */
public class Q343 {
    public static void main(String[] args) {
        int i = new Solution343().integerBreak(2);
        System.out.println(i);
    }
}

class Solution343 {
    public int integerBreak(int n) {
        if (n < 2)
            return -1;
        int[] dp = new int[n + 1];
        dp[2] = 1;//2
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1];//本轮初始值
            for (int k = 2;k <= (i / 2) + 1;k++){
                dp[i] = Math.max(dp[i],Math.max(k * (i - k),dp[i - k] * k));//2 * 3 与 2 * dp[3]比较作为本轮，本轮的dp[i]和上轮的dp[i]比
            }
        }
        return dp[n];
    }
}
