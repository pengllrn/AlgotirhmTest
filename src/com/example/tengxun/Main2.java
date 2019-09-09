package com.example.tengxun;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/1 20:26</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        long[] sum = new long[n];
        for (int i = 0; i < n; i++){
            w[i] = sc.nextInt();
            if(i == 0) sum[i] = w[i];
            else sum[i] = sum[i-1] + w[i];
        }
        long[] dp = new long[n];
        dp[0] = w[0] * w[0];
        long max = dp[0];
        for (int i = 1; i < n; i++) {
            long cur = w[i] * w[i];
            int min = w[i];
            for (int j = i - 1; j >= 0; j--) {
                if(w[j] >= min) {
                    cur = min * (sum[i] - sum[j] + w[j]);
                    continue;
                }else {
                    long tmp = w[j] * (sum[i] - sum[j] + w[j]);
                    if(tmp < cur) break;
                    min = w[j];
                    cur = tmp;
                }
            }
            dp[i] = cur;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
