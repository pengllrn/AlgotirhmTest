package com.example.beike;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/10 20:15</pre>
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] up = new int[n];
        up[0] = nums[0];
        for (int i = 1; i < n; i++) {
            up[i] = Math.max(up[i - 1] + 1, nums[i]);
        }
        int[] down = new int[n];
        down[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            down[i] = Math.max(nums[i], down[i + 1] + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = Math.min(up[i], down[i]);
            ans += c - nums[i];
            up[i] = c;
        }
        for (int i = 1; i < n; i++){
            if(up[i] == up[i - 1]){
                ans += 1;
                break;
            }
        }
        System.out.println(ans);
    }
}
