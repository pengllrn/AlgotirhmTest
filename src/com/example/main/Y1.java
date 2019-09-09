package com.example.main;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 15:25</pre>
 */
public class Y1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[151];
        int[] origin = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = sc.nextInt();
            score[origin[i]]++;
        }
        int[] sum = new int[151];
        sum[0] = 0;
        for (int i = 1; i < 151; i++) {
            sum[i] += sum[i - 1] + score[i - 1];
        }
        int q = sc.nextInt();
        int[] query = new int[q];
        for (int i = 0; i < q; i++) {
            query[i] = sc.nextInt();
        }
        DecimalFormat format = new DecimalFormat("0.000000");
        for (int i = 0; i < q; i++) {
            int idx = sum[origin[query[i] - 1]];
            String s = format.format(idx / (double) n);
            System.out.println(s);
        }
    }
}
