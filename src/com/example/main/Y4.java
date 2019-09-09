package com.example.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 15:56</pre>
 */
public class Y4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[] query = new int[q];
        for (int i = 0; i < q; i++){
            query[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < q; i++){
            int idx = binarySearch(nums, query[i]);
            if(nums[idx] < query[i]){
                System.out.println(0);
                continue;
            }
            int cnt = n - idx;
            System.out.println(cnt);
            for (int j = 0; j < cnt; j++){
                nums[idx + j]--;
            }
        }
    }
    private static int binarySearch(int[] score, int key){
        int left = 0;
        int right = score.length - 1;
        while (left < right){
            int mid = left + (right - left) /2;
            if(score[mid] >= key){
                right = mid;
            }else
                left = mid + 1;
        }
        return left;
    }
}
