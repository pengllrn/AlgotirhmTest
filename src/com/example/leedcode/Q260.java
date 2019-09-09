package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 15:50</pre>
 */
public class Q260 {
    public static void main(String[] args) {
        int[] ints = new Solution260().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));
    }
}

/**
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 */
class Solution260{
    public int[] singleNumber(int[] nums) {
        if(nums == null)
            return null;
        int diff = 0;
        for (int num : nums){
            diff ^= num;
        }
        diff &= -diff;
        int[] ret = new int[2];
        for (int num : nums){
            if((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }
        return ret;
    }
}
