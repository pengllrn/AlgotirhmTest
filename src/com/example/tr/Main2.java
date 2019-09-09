package com.example.tr;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/29 20:03</pre>
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[] tails = new int[n];
        int len = 0;
        for (int i = 0 ; i < n; i++){
            int idx = binarySearch(tails, len, nums[i]);
            if(nums[i] == tails[idx] || len == idx){
                len++;
                if (nums[i] == tails[idx]) idx++;
            }
            tails[idx] = nums[i];
        }
        System.out.println(len);
    }

    private static int binarySearch(int[] tails, int len, int key){
        int l = 0, r = len;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(tails[mid] == key)
                return mid;
            else if(tails[mid] > key)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
