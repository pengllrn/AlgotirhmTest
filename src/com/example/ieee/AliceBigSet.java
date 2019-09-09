package com.example.ieee;

import java.util.ArrayList;
import java.util.Scanner;

public class AliceBigSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] initial = new int[n];
        long sum = 0;
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
        long result = new BigSet().sum(sum, max, secondMax, k);
        System.out.println(result);


    }
}

class BigSet {
    private final int mod = 10000007;

    public long sum(long init, long max, long sendMax, int k) {
        long[][] fb = new long[][]{{max + sendMax, max}, {max, sendMax}};
        long[][] core = new long[][]{{1, 1}, {1, 0}};
        ArrayList<long[][]> list = new ArrayList<>();
        list.add(core);
        int index = 1;
        while (index <= k) {
            index = index << 1;
            core = compueArray(core, core);
            list.add(core);
        }
        int j = 0;
        long[][] result = new long[][]{{1, 0}, {0, 1}};
        while (k != 0) {
            if ((k & 1) == 1) {
                result = compueArray(result, list.get(j));
            }
            j++;
            k = k >> 1;
        }
        long[][] longs = compueArray(result, new long[][]{{1, 1}, {1, 0}});
        long[][] minors = minors(longs, new long[][]{{1, 1}, {1, 0}});
        long[][] longs1 = compueArray(fb, minors);
        long reslut = longs1[0][0] + init;
        return reslut > 0 ? reslut : reslut % mod;
    }

    private long[][] compueArray(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];
        result[0][0] = (arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]) % mod;
        result[0][1] = (arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]) % mod;
        result[1][0] = (arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]) % mod;
        result[1][1] = (arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]) % mod;
        return result;
    }

    private long[][] minors(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];
        result[0][0] = (arr1[0][0] - arr2[0][0]) % mod;
        result[0][1] = (arr1[0][1] - arr2[0][1]) % mod;
        result[1][0] = (arr1[1][0] - arr2[1][0]) % mod;
        result[1][1] = (arr1[1][1] - arr2[1][1]) % mod;
        return result;
    }
}
