package com.example.other;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 14:35</pre>
 */
public class TxTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//机器
        int m = sc.nextInt();//任务
        int[][] mech = new int[n][2];
        for (int i = 0; i < n; i++){
            int[] mi = new int[2];
            mi[0] = sc.nextInt();
            mi[1] = sc.nextInt();
            mech[i] = mi;
        }
        int[][] task = new int[m][2];
        for (int i = 0; i < m; i++){
            int[] ti = new int[2];
            ti[0] = sc.nextInt();
            ti[1] = sc.nextInt();
            task[i] = ti;
        }


    }
}
