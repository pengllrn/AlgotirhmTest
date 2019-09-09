package com.example.leedcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pengllrn
 * @since <pre>2019/6/25 9:09</pre>
 */
public class Q217 {
}

class Solution217{
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1)
            return false;
        Map<Integer,Boolean> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num))
                return true;
            map.put(num,true);
        }
        return false;
    }
}
