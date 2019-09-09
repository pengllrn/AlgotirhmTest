package com.example.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/23 23:06</pre>
 */
public class Solutionbk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        long diff = sum;
        long small = sum;
        long large = 0;
        int i = n - 1;
        for (; i >= 0; i--){
            large += nums[i];
            small -= nums[i];
            long curDiff = Math.abs(small - large);
            if(curDiff > diff){
                i++;
                break;
            }else {
                diff = curDiff;
            }
        }
        System.out.print(diff + " ");//和差
        System.out.println(Math.abs(n - i - 1 - i - 1));//数量差
    }
}
