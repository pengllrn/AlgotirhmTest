package com.example.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/7/30 20:25</pre>
 */
public class E4 {
    static class Box {
        int len;
        int weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Box[] b = new Box[n];
        for (int i = 0; i < n; ++i) {
            b[i] = new Box();
            b[i].len = in.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            b[i].weight = in.nextInt();
        }
        Arrays.sort(b, (b1, b2) -> b1.len == b2.len ? b1.weight - b2.weight : b1.len - b2.len);
        int res = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = b[0].weight;
        for (int i = 1; i < n; ++i) {
            int prevMax = 0;
            int maxj = 0;
            for (int j = 0; j < i; ++j) {
                if (b[j].len < b[i].len && dp[j][1] <= b[i].weight * 7) {
                    if (dp[j][0] > prevMax) {
                        prevMax = dp[j][0];
                        maxj = j;
                    }
                }
            }
            dp[i][0] = prevMax + 1;
            dp[i][1] = dp[maxj][1] + b[i].weight;
            res = Math.max(dp[i][0], res);
        }
        Arrays.sort(new int[][]{}, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        System.out.println(res);
    }
}