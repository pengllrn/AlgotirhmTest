package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 15:42</pre>
 */
public class Q268 {
    public static void main(String[] args) {
        int i = new Solution268().missingNumber(new int[]{0,6,4,2,3,5,7,8,1});
        System.out.println(i);
    }
}
class Solution268{
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int ret = 0;
        for (int i = 0;i<nums.length;i++){
            ret = ret ^ nums[i] ^ i;
        }
        return ret ^ nums.length;
    }
}
