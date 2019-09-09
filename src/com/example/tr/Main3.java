package com.example.tr;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/29 20:33</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//人数
        int m = sc.nextInt();//语言数
        int k = sc.nextInt();//关系
        if(k == 0) {
            System.out.println(n);
            return;
        }
        int[][] ship = new int[n + m][n + m];
        for (int i = 0; i < n + m; i++) {
            ship[i][i] = 1;
        }
        for (int i = 0 ; i < k; i++){
            int a = sc.nextInt() - 1;
            int b= sc.nextInt() - 1;
            ship[a][a + b] = 1;
            ship[a + b][a] = 1;
        }
        int cnt = 0;
        boolean[] marked = new boolean[n + m];
        int[][] der = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i< n; i++){
            for (int j = i; j < n + m; j++) {
                if(ship[i][j] != 1 || marked[i] || marked[j]) continue;
                for (int[] d : der){
                    int ni = i + d[0], nj = j + d[1];
                    if(ni < 0 || ni == n || nj < ni || nj == n + m || marked[ni] || marked[nj]){

                    }
                }
            }
        }
    }
}
