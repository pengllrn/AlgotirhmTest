package com.example.ali;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/30 19:49</pre>
 */
public class Main1 {
    private static ArrayList<Integer> ans = new ArrayList<>();
    private static int max = Integer.MAX_VALUE;
    private static int M;//划分多少次
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        backtrack(0, new ArrayList<>(), 0);
        int p = 0;
        System.out.println(max);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
            if (p < M - 1 && ans.get(p) == i) {
                p++;
                System.out.print("/ ");
            }
        }
    }

    private static void backtrack(int start, ArrayList<Integer> list, int curMax) {
        if (list.size() == M - 1) {
            if (list.size() == 0) {
                max = getLast(0);
                return;
            }
            int c = Math.max(getLast(list.get(list.size() - 1) + 1), curMax);
            if (c < max) {
                ans = new ArrayList<>(list);
                max = c;
            }
            return;
        }
        int sum = 0;
        int end = nums.length - M + list.size();
        for (int i = start; i <= end && sum < max; i++) {
            sum += nums[i];
            list.add(i);
            backtrack(i + 1, list, Math.max(curMax, sum));
            list.remove(list.size() - 1);
        }
    }

    private static int getLast(int idx) {
        int ret = 0;
        for (int i = idx; i < nums.length && ret < max; i++) {
            ret += nums[i];
        }
        return ret;
    }
}
