package com.example.beike;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/10 19:12</pre>
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
        for (int i = 0; i < n; i++){
            int index= bns(tails, len, nums[i]);
            tails[index] = nums[i];
            if(index == len){
                len++;
            }
        }
        System.out.println(len);
    }

    private static int bns(int[] nums, int len, int key){
        int l = 0, h = len;
        while (l < h){
            int mid = l + (h - l) / 2;
            if(nums[mid] == key){
                return mid;
            }else if(nums[mid] > key){
                h = mid;
            }else
                l = mid + 1;
        }
        return l;
    }
}
