package com.example.practice;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/25 17:13</pre>
 */
public class PackageMinCountSquare {
    public int numSquares(int n){
        if(n <= 0) return -1;
        int[] dp = new int[n + 1];
        ArrayList<Integer> items = squares(n);
        for (int i = 0; i <= n; i++){
            dp[i] = 5;
            for (int item : items){
                if(item > i) break;
                dp[i] = Math.max(dp[i], dp[i - item] + 1);
            }
        }
        return dp[n];
    }

    private ArrayList<Integer> squares(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int sq = 1;
        int diff = 3;
        while (sq <= n){
            list.add(sq);
            sq += diff;
            diff += 2;
        }
        return list;
    }
}
