package com.example.other;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 19:07</pre>
 */
public class TestSwap {
    public static void main(String[] args) {
        int[] ans = new int[]{1,2,3,4,5};
        TestSwap testSwap = new TestSwap();
        testSwap.swap(ans,0,1);//2,1,3,4,5
        testSwap.swap(ans,2,4);//2,1,5,4,3
        testSwap.swap(ans,1,3);//2,4,5,1,3
        System.out.println(Arrays.toString(ans));
    }

    private void swap(int[] nums,int i,int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}

