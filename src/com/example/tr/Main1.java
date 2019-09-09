package com.example.tr;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/29 19:28</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int k = sc.nextInt();//k个数
        int x = sc.nextInt();//target
        String[] sp = input.split(",");
        int n = sp.length;
        int[] nums = new int[n];
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.valueOf(sp[i]);
            sum[i + 1] = sum[i] + Math.abs(nums[i] - x);;
        }
        int l = -1, r = k - 1;
        long prev = Integer.MAX_VALUE;
        while (r < n && sum[r + 1] - sum[l + 1] < prev){
            prev = sum[++r] - sum[++l];
        }
        for (int i = l; i < r; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
