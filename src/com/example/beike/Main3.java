package com.example.beike;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/10 19:31</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] rooms = new int[n];
        rooms[0] = sc.nextInt();
        for (int i = 1 ; i < n; i++){
            rooms[i] = sc.nextInt() + rooms[i - 1];
        }
        int[][] check = new int[m * 2][2];
        int a , b;
        int r = 0;
        for (int i = 0; i < m * 2; i+=2){
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            check[i][0] = a;
            check[i][1] = 1;
            check[i + 1][0] = b;
            check[i + 1][1] = -1;
            if(a == 0){
                r += rooms[b];
            }else {
                r += rooms[b] - rooms[a - 1];
            }
        }
        Arrays.sort(check, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] dp = new int[m * 2];
        int ans = 1;
        int k = 1;
        dp[0] = 1;
        for (int i = 1; i < m * 2; i++) {
            dp[k] = dp[k - 1] + check[k][1];
            ans = Math.max(ans, dp[k]);
            k++;
        }
        System.out.println(ans + r);
    }
}
