package com.example.tx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n ;i ++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int lastR = 0;
        int curR = arr[0][1];
        int cnt = 1;
        for (int i = 1; i < n && curR < L; i++){
            if(arr[i][1] < curR || arr[i][0] > curR)
                continue;
            if(arr[i][0] <= lastR && arr[i][1] > curR){
                curR = arr[i][1];
            }else {
                lastR = curR;
                curR = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
