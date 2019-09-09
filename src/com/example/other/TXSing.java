package com.example.other;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 13:27</pre>
 */
public class TXSing {
    private static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int L1 = sc.nextInt();
        int N1 = sc.nextInt();
        int L2 = sc.nextInt();
        int N2 = sc.nextInt();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < N1 + N2; i++){
            int w = i >= N1 ? L2 : L1;
            for (int j = size; j >= w; j--){
                dp[j] =(dp[j] + dp[j - w] ) % mod;
            }
        }
        System.out.println(dp[size]);
    }
}
