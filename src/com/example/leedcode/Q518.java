package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/9 16:36</pre>
 */
public class Q518 {
    public static void main(String[] args) {
        int change = new Solution518().change(0, new int[]{});
        System.out.println(change);
    }
}

/**
 * 01背包
 * dp[i][j] 前i个金币可以凑成j的组合数
 * dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-coin])
 */
class Solution518 {
    public int change(int amount, int[] coins) {
        if (coins == null || amount < 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
//                dp[j] = Math.max(dp[j], dp[j - coin] + 1);
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }
}
