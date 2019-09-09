package com.example.tengxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Pengllrn
 * @since <pre>2019/9/1 21:00</pre>
 */
public class Main4 {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long kthNumber = findKthNumber(arr1, arr2, k);
        System.out.println(kthNumber);
    }

    public static long findKthNumber(int[] arr1, int[] arr2, long k) {
        long lo = 1, hi = arr1[n - 1] * arr2[n - 1];
        long mid, count;
        while (lo < hi) {
            mid = lo + (hi - lo + 1) / 2;
            count = 0;
            for (int i = 0; i < n && arr1[i] <= mid; i++) {
                for (int j = 0; j < n; j++) {
                    long cnt = mid / arr1[i] * arr2[j] > n ? n : mid / arr1[i] * arr2[j];
                    if (cnt == 0) break;
                    count += cnt;
                }
            }
            if (count == k) return mid;
            else if(count > k) hi = mid - 1;
            else lo = mid;
        }
        return lo;
    }
}
/*
3 2
1 2 3
2 3 4

 */