package com.example.leedcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/9/4 22:42</pre>
 */
public class Main279 {
    public static void main(String[] args) {
        int i = new Solution279().numSquares(43);
        System.out.println(i);
    }
}

class Solution279 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquare(n);
        int[] dp = new int[n + 1];
        for (Integer sq : squares){
            for (int i = sq; i <= n; i++) {
                if(i == sq) dp[i] = 1;
                else if(dp[i] != 0 && dp[i - sq] != 0){
                    dp[i] = Math.min(dp[i], dp[i - sq] + 1);
                }else if(dp[i - sq] != 0){
                    dp[i] = dp[i - sq] + 1;
                }
            }
        }
        return dp[n];
    }

    private List<Integer> generateSquare(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 1, diff = 3;
        while (i <= n){
            res.add(i);
            i += diff;
            diff += 2;
        }
        return res;
    }
}
