package com.example.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pengllrn
 * @since <pre>2019/7/4 23:49</pre>
 */
public class Solution22 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder ans = new StringBuilder();
        for(String s : nums)
            ans.append(s);
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = new Solution22().PrintMinNumber(new int[]{3, 32, 321});
        System.out.println(s);
    }
}
