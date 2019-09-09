package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 15:37</pre>
 */
public class Q136 {
}

class Solution136{
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num : nums) ret = ret ^ num;
        return ret;
    }
}
