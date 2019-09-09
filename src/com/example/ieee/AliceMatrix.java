package com.example.ieee;

import java.util.Scanner;

public class AliceMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] result = new long[t];
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int n = in.nextInt();
            int[] row1 = new int[n];
            int[] col1 = new int[n];
            for (int j = 0; j < n; j++) {
                col1[j] = in.nextInt();//第一列数
            }
            for (int j = 0; j < n; j++) {
                row1[j] = in.nextInt();//第一行数
            }
            result[i] = new AlicelM().ressult(a, row1, col1);
        }
        for (int j = 0; j < result.length; j++) {
            System.out.println("case " + j + ": " + result[j]);
        }

    }
}

class AlicelM {

    /**
     * a 小于100000
     * n = row.length
     *
     * @param a
     * @param row
     * @param col
     * @return
     */
    private final int mod = 100000007;

    public long ressult(int a, int[] row, int[] col) {
        int n = col.length;
        long[][] dp = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = row[i - 1];
        }

        int flag = 0;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {//每一行  10wan * 10wan
            dp[flag][1] = col[i - 1];
            for (int j = 2; j <= n; j++) {
                dp[flag][j] = ((a * dp[1 - flag][j]) + (a * dp[flag][j - 1])) % mod;
            }
        }
        return dp[1 - flag][n];
    }
}
