package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/25 19:16</pre>
 */
public class Main8 {
    private static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = n / 2;
        long[] dp = new long[size + 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= size; i++){
            for (int j = 0; j < i; j++){
                if(j == 0) dp[i] += dp[i - 1] % mod;
                else {
                    dp[i] += (dp[j] * dp[i - j - 1]) % mod;
                    dp[i] = dp[i] % mod;
                }
            }
        }
        System.out.println(dp[size]);
    }
}
