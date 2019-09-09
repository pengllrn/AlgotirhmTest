package com.example.other;

/**
 * @author Pengllrn
 * @since <pre>2019/6/8 22:40</pre>
 */
//0 1背包问题
public class PackageOf01 {
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int w = weights[i - 1], v = values[i - 1];
                if (w <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);//放或者不放的最大值
                else//只能不放
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int knapsack = new PackageOf01().knapsack(12, 4, new int[]{3, 6, 8, 4}, new int[]{3, 6, 8, 2});
        System.out.println(knapsack);
    }
}

class PackageOf01_2 {
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = W; j > 0; j--) {
                int w = weights[i-1], v = values[i-1];
                if(j >= w){//第i件物品放得下
                    dp[j] = Math.max(dp[j],dp[j-w] + v);
                }
            }
        }
        return dp[W];
    }
}

