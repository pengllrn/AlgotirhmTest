package com.example.xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/9/4 20:18</pre>
 */
public class Main4 {
    private static int max = Integer.MAX_VALUE;
    private static int[] nums;

    static int schedule(int m, int[] array) {
        nums = array;
        backtrack(m, 0, new ArrayList<>(), 0);
        return max;
    }

    private static void backtrack(int m, int start, ArrayList<Integer> list, int curMax) {
        if (list.size() == m - 1) {
            if (list.size() == 0) {
                max = getLast(0);
                return;
            }
            int c = Math.max(getLast(list.get(list.size() - 1) + 1), curMax);
            if (c < max) {
                max = c;
            }
            return;
        }
        int sum = 0;
        int end = nums.length - m + list.size();
        for (int i = start; i <= end && sum < max; i++) {
            sum += nums[i];
            list.add(i);
            backtrack(m, i + 1, list, Math.max(curMax, sum));
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}