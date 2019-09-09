package com.example.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/6 20:24</pre>
 */
public class Main3 {
    private static int n;
    private static int m;
    private static int k;
    private static int[][][] arrays = new int[k][n][m];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arrays = new int[k][n][m];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <n ; j++) {
                for (int l = 0; l < m; l++) {
                    arrays[i][j][l] = sc.nextInt();
                }
            }
        }
        if(k == 1) {
            System.out.println(1);
            return;
        }
        int[][] bk = new int[n][m];
        for (int i = 0; i < k; i++) {
            bk = xor(bk, arrays[i]);
        }
        boolean[] marked = new boolean[k];
        Arrays.fill(marked, true);
        int split = split(marked, k, bk);
        System.out.println(split);
    }

    private static int split(boolean[] marked, int r, int[][] bk){
        if(r == 1) return 0;
        if(!hasOnes(bk)) return -1;
        int i = 0, j = 0;
        for (; i < n; i++) {
            for (; j < m; j++) {
                if(bk[i][j] == 1) break;
            }
            if(bk[i][j] == 1) break;
        }
        int nr = 0;
        boolean[] markedA = new boolean[k];
        boolean[] markedB = new boolean[k];
        int[][] nbka = new int[n][m];
        int[][] nbkb = new int[n][m];
        for(int l = 0; l < k; l++){
            if(!marked[l]) continue;
            if(arrays[l][i][j] == 1) {
                markedA[l] = true;
                nr++;
                nbka = xor(nbka, arrays[l]);
            }else {
                markedB[l] = true;
                nbkb = xor(nbkb, arrays[l]);
            }
        }

        int left = split(markedA, nr, nbka);
        int right = split(markedB, r - nr, nbkb) ;
        if(left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;
    }

    private static boolean hasOnes(int[][] a){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] == 1) return true;
            }
        }
        return false;
    }

    private static int[][] xor(int[][] a, int[][] b){
        int n = a.length;
        int m = a[0].length;
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = a[i][j] ^ b[i][j];
            }
        }
        return ret;
    }

}

/**

 3 3 2
 1 0 1
 0 0 0
 1 1 1
 0 1 0
 0 0 0
 1 1 1
 */