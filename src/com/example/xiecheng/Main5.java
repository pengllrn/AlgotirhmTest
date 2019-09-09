package com.example.xiecheng;

/**
 * @author Pengllrn
 * @since <pre>2019/9/5 11:15</pre>
 */
public class Main5 {
    public static void main(String[] args) {
        int combine = new Solution5().combine(4);
        System.out.println(combine);
    }
}


class Solution5 {
    public int combine(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i + 2; j++) {//i个数从2,..,2+i
                int rest = (i * 2 - j + 1) / 2;
                dp[i] += dp[rest];
            }
        }
        return dp[n];
    }

    public int combine2(int n){
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return dp[n][n];
    }
}