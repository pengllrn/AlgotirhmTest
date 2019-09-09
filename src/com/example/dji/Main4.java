package com.example.dji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 20:26</pre>
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();//路标数
            int P = sc.nextInt();//path 连通数
            int C = sc.nextInt();//比赛轮数
            int[][] path = new int[N][N];
            for (int i = 0; i < P; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                path[a][b] = sc.nextInt();
                path[b][a] = path[a][b];
            }
            int[] dp = new int[N];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(j == 0){
                        dp[j] = dp[j];
                    }else if(i == 0){
                        dp[j] = dp[j - 1];
                    }else{
                        dp[j] = Math.min(dp[j - 1], dp[j]);
                    }
//                    if(path[i][j] == 0 && i != j){
//                        dp[j] = Integer.MAX_VALUE;
//                    }else
                        dp[j] += path[i][j];
                }
            }

            int ans = 0;
            for (int i = 0; i < C; i++){
                int end = sc.nextInt();
                ans += dp[end];
            }
            System.out.println(ans);
        }
    }
}
/*
4 5 3
0 1 15
1 2 15
0 3 50
1 3 30
2 3 10
2
1
3
 */