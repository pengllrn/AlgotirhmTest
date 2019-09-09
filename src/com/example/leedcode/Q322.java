package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/9 14:52</pre>
 */
public class Q322 {
    public static void main(String[] args) {
        int i = new Solution322().coinChange(new int[]{1}, 0);
        System.out.println(i);
    }
}

/**
 * dp[i][j]表示前i个硬币，凑成总金额为j所需要的最少硬币数
 * dp[i][j]的取值：0：之前没有搜索到的（不可能存在0这样情况）或者无法凑成  >0 : 硬币数
 * 对于第i个硬币，可以凑出的金额范围为coins[i] ---->amount（即j的取值范围）
 * 对于每一个需要凑出的金额j，如果刚好是当前金币i的面值，则dp[i][j]=1，否则：
 * 1.可以选择使不使用用当前金币,看哪种情况最优：Math.min(dp[i-1][j-coins[i]] + 1,dp[i-1][j])
 * 2.由于刚开始dp[i-1][j]或dp[i-1][j-coins[i]]是0时，需要谨慎；
 * 3.如果：dp[i-1][j]==0 && dp[i-1][j- coin] !=0  ------>dp[i][j] = dp[i-1][j-coin] + 1
 * 4.dp[i-1][i-coin] !=0  ------>  Math.min(dp[i-1][j-coins[i]] + 1,dp[i-1][j])
 */
class Solution322 {//多重背包：可重复选取相同的物品，凑成最终的结果，使得所选择的物品数最少
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (j == coin)//使用这个金币1次即可
                    dp[j] = 1;
                else if (dp[j - coin] != 0 && dp[j] == 0) {//使用这个金币，但规则失效
                    dp[j] = dp[j - coin] + 1;
                } else if (dp[j - coin] != 0)//使用这个金币，规则有效
                    dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
                else //dp[j - coin] == 0(无法使用i-1个金币凑出j-coin) 。这种情况下无法使用这个金币，复用上一轮的结果
                    dp[j] = dp[j];
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
