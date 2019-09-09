package com.example.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] tails = new int[N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(tails, len, arr[i][1]);
            if (tails[idx] == arr[i][1]) idx++;
            tails[idx] = arr[i][1];
            if (idx >= len) {
                len++;
            }
        }
        System.out.println(len);
    }

    private static int binarySearch(int[] nums, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > key) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
