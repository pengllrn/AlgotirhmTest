package com.example.leedcode;

public class Q62 {
    public static void main(String[] args) {
        long i = new TotalPath().uniquePaths(39, 29);
        System.out.println(i);
    }
}

class TotalPath{

    public int uniquePaths(int m, int n) {
        if(m <=0 ||n <= 0)
            return 0;
        int[] dp = new int[n];
        for (int i = 0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(j == 0 || i == 0)
                    dp[j] = 1;
                else
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }
}
