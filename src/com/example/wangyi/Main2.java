package com.example.wangyi;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/4 15:10</pre>
 */
public class Main2 {
    static class Pair {
        int v1;
        int v2;
        public Pair(int v1, int v2){
            this.v1 = v1;
            this.v2 = v2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        Pair pair = maxProfit(nums, 0, nums.length - 1);
        System.out.print(pair.v1 + " " + pair.v2);
    }

    private static Pair maxProfit(int[] nums, int left, int right){
        if(left - right <= 1){
            if(left == right){
                return new Pair(nums[left], 0);
            }else {
                if(nums[left] < nums[right]){
                    int tmp = left;
                    left = right;
                    right = tmp;
                }
                return new Pair(nums[left], nums[right]);
            }
        }

        return null;
    }
}
