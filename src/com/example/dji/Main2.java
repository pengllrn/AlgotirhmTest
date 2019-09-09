package com.example.dji;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 19:55</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int T = sc.nextInt();//钱
            int[][] goods = new int[N][3];
            int SN = 0;
            for (int i = 0; i < N; i++){
                goods[i][0] = sc.nextInt();//价格
                goods[i][1] = sc.nextInt();//满意度
                goods[i][2] = sc.nextInt();//数量
                SN += goods[i][2];

            }
            int[][] prod = new int[SN][2];
            int k = 0;
            for (int i = 0; i< N; i++){
                for (int j =0; j < goods[i][2]; j++){
                    prod[k][0] = goods[i][0];
                    prod[k++][1] = goods[i][1];
                }
            }
            int[] dp = new int[T + 1];
            for (int[] item : prod){
                for (int j = T; j >= item[0]; j--){
                    dp[j] = Math.max(dp[j], dp[j - item[0]] + item[1]);
                }
            }
            System.out.println(dp[T]);
        }
    }
}
