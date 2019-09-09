package com.example.leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pengllrn
 * @since <pre>2019/6/25 8:54</pre>
 */
public class Q1 {
    public static void main(String[] args) {
        int[] ints = new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
