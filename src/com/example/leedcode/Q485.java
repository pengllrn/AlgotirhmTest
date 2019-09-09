package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/22 14:13</pre>
 */
public class Q485 {
    public static void main(String[] args) {
        int max = new Solution485().findMaxConsecutiveOnes(new int[]{0, 1, 0, 1, 1, 1});
        System.out.println(max);
    }
}


class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxCount = 0;
        int curCount = 0;
        for (int num : nums) {
            if (num != 1) {
                maxCount = Math.max(maxCount, curCount);
                curCount = 0;
            }else
                curCount++;
        }
        maxCount = Math.max(curCount,maxCount);
        return maxCount;
    }
}