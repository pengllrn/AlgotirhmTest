package com.example.leedcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Pengllrn
 * @since <pre>2019/6/20 13:06</pre>
 */
public class Q503 {
}

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int curIndex = 0;curIndex < n * 2;curIndex ++){
            int val = nums[curIndex % n];
            while (!stack.isEmpty() && val > nums[stack.peek()]){
                int preIndex= stack.pop();
                ans[preIndex] = val;
            }
            if(curIndex < n)
                stack.push(curIndex);
        }
        return ans;
    }
}

