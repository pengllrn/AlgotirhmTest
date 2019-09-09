package com.example.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/3 16:26</pre>
 */
public class Y2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] input = new int[t][];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            input[i] = arr;
        }
        for (int i =0; i < t; i++){
            Arrays.sort(input[i]);
            int[] nums = input[i];
            int left = nums.length / 2;
            int k = left;
            for (int l = 0; l < left - 1; l++){
                if(nums[l] + nums[l + 1] < nums[k++]){
                    System.out.println("NO");
                    return;
                }
            }
            if(nums[nums.length - 1] > nums[0] + nums[nums.length - 2]){
                System.out.println("NO");
                return;
            }

            System.out.println("YES");
        }
    }
}
