package com.example.ieee;

import java.util.ArrayList;
import java.util.Scanner;

public class AliceBigSet1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] initial = new int[n];
        int sum = 0;
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < n; i++) {
            initial[i] = in.nextInt();
            sum += initial[i];
            if (initial[i] > max) {
                secondMax = max;
                max = initial[i];
            }
        }
        int result = new BigSet1().sum(sum, max, secondMax, k);
        System.out.println(result);


    }
}

class BigSet1 {
    private final int mod = 10000007;

    public int sum(int init, int max, int sendMax, int k) {
        int[][] fb = new int[][]{{max + sendMax, max}, {max, sendMax}};
        int[][] core = new int[][]{{1, 1}, {1, 0}};
        ArrayList<int[][]> list = new ArrayList<>();
        list.add(core);
        int index = 1;
        while (index <= k) {
            index = index << 1;
            core = compueArray(core, core);
            list.add(core);
        }
        int j = 0;
        int[][] result = new int[][]{{1, 0}, {0, 1}};
        while (k != 0) {
            if ((k & 1) == 1) {
                result = compueArray(result, list.get(j));
            }
            j++;
            k = k >> 1;
        }
        int[][] longs = compueArray(result, new int[][]{{1, 1}, {1, 0}});
        int[][] minors = minors(longs, new int[][]{{1, 1}, {1, 0}});
        int[][] longs1 = compueArray(fb, minors);
        int reslut = longs1[0][0] + init;
        return reslut > 0 ? reslut : reslut % mod;
    }

    private int[][] compueArray(int[][] arr1, int[][] arr2) {
        int[][] result = new int[2][2];
        result[0][0] = (arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]);
        result[0][1] = (arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]);
        result[1][0] = (arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]);
        result[1][1] = (arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]);
        return result;
    }

    private int[][] minors(int[][] arr1, int[][] arr2) {
        int[][] result = new int[2][2];
        result[0][0] = (arr1[0][0] - arr2[0][0]);
        result[0][1] = (arr1[0][1] - arr2[0][1]);
        result[1][0] = (arr1[1][0] - arr2[1][0]);
        result[1][1] = (arr1[1][1] - arr2[1][1]);
        return result;
    }
}
