package com.example.aiqiyi;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/8 15:49</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            A[i] = sc.nextInt();
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        int cntOne = A[0] == 1 ? 1 : 0;
        int cntZero = A[0] == 0 ? 1 : 0;
        for (int i = 2; i <= N; i++) {
            if(A[i - 2] == 1) {
                dp[i] = dp[i - 1] + cntZero;
                cntOne++;
            }else {
                dp[i] = dp[i - 1] + cntOne;
                cntZero++;
            }
        }
        System.out.println(dp[N]);
    }
}



