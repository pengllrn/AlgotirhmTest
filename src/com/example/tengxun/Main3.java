package com.example.tengxun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/1 20:36</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (arr[i - 1][0]) * (i - 1) + (arr[i - 1][1]) * (n - i);
        }
        System.out.println(sum);
    }
}
