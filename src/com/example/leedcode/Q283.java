package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 17:25</pre>
 */
public class Q283 {
    public static void main(String[] args) {
        int[] input = new int[]{0,1};
        new Solution283().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}

/**
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
class Solution283 {
    public void moveZeroes(int[] nums){
        int idx = 0;
        for (int num : nums){
            if(num != 0)
                nums[idx++] = num;
        }
        while (idx < nums.length)
            nums[idx++] = 0;
    }
}
