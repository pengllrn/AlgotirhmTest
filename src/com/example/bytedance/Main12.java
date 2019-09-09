package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/30 22:20</pre>
 */
public class Main12 {
    private static int[][] road;
    private static int min = Integer.MAX_VALUE;
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        road = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                road[i][j] = sc.nextInt();
//            }
//        }
        if(n == 1){
            System.out.println(0);
            return;
        }
        boolean[] marked = new boolean[n];
        marked[0] = true;
        for (int i = 1; i < n; i++){
            marked[i] = true;
            backtrack(marked, 1, i, road[0][i]);
            marked[i] = false;
        }
        System.out.println(min);
    }

    private static void backtrack(boolean[] marked, int cnt, int idx, int sum){
        if(cnt >= n - 1){
            min = Math.min(min, sum + road[idx][0]);
            return;
        }
        for (int i = 1; i < n; i++) {
            if(marked[i]) continue;
            marked[i] = true;
            backtrack(marked, cnt + 1, i, sum + road[idx][i]);
            marked[i] = false;
        }
    }
}
