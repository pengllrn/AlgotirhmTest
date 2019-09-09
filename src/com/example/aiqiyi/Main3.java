package com.example.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/8 18:39</pre>
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int x = sc.nextInt();
        arr[0] = x;
        int y = sc.nextInt();
        arr[1] = y;
        int z = sc.nextInt();
        arr[2] = z;
        int k = sc.nextInt();
        Arrays.sort(arr);
        split(arr, k, 0);
        long ret = (x - arr[0] + 1) * (y - arr[1] + 1) * (z - arr[2] + 1);
        System.out.println(ret);
    }

    private static void split(int[] arr, int k, int i) {
        if (i == 3) return;
        int avg = k / (3 - i);
        if (avg >= arr[i]) {
            for (int j = i + 1; j < 3; j++) {
                arr[j] -= arr[0] - 1;
                arr[j] -= arr[0] - 1;
            }
            arr[i] = 1;
            split(arr, k - 3 * (arr[0] - 1), i + 1);
        } else {
            for (int j = i; j < 3; j++) {
                arr[j] -= avg;
            }
            split(arr, k - (3 - i) * avg, i + 1);
        }
    }
}
