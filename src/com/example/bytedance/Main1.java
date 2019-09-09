package com.example.bytedance;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/6/30 22:06</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arrays = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arrays[i] = in.nextInt();
        }
        in.close();
        int jump = new Solution().jump(arrays, k);
        System.out.println(jump);
    }
}

class Solution {
    private int cnt = Integer.MAX_VALUE;

    public int jump(int[] nums, int k) {
        jumpCore(nums, new boolean[nums.length], k, 0);
        return cnt == Integer.MAX_VALUE ? -1 : cnt + 1;
    }

    private void jumpCore(int[] nums, boolean[] marked, int index, int sum) {
        int start = index - nums[index] > 0 ? index - nums[index] : 1;
        int end = index + nums[index];//3
        if (end >= nums.length) {
            cnt = Math.min(cnt, sum);
            return;
        }

        for (int i = start; i <= end && sum < cnt - 1; i++) {
            if (marked[i] || nums[i] == 0 || i == index)
                continue;
            marked[i] = true;
            jumpCore(nums, marked, i, sum + 1);
            marked[i] = false;
        }
    }

}
