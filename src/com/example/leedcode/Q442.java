package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 10:48</pre>
 */
public class Q442 {
    public static void main(String[] args) {
        List<Integer> ans = new Solution442().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(ans);
    }
}

//重复的数据
class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {//4, 3, 2, 7, 8, 2, 3, 1   ==>-4, -3, -2, -7, 8, 2, -3, -1
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return ans;
        for (int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                ans.add(Math.abs(nums[i]));
            else
                nums[index] *= -1;
        }
        return ans;
    }
}

