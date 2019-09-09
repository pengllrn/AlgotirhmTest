package com.example.leedcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 19:01</pre>
 */
public class Q697 {
    public static void main(String[] args) {
        int td = new Solution697().findShortestSubArray(new int[]{0, 2, 4, 3, 1});
        System.out.println(td);
    }
}

/**
 * 非空且只包含非负数
 * [1,2,2,3,1,4,2]  6
 */
class Solution697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numStart = new HashMap<>();
        Map<Integer, Integer> numEnd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
            numEnd.put(num, i);
            if (!numStart.containsKey(num)) {
                numStart.put(num, i);
            }
        }
        int maxCnt = 0;
        for (Integer num : numCnt.keySet()) {
            maxCnt = Math.max(maxCnt, numCnt.get(num));
        }
        if (maxCnt == 1)
            return 1;
        int minLen = Integer.MAX_VALUE;
        for (Integer num : numStart.keySet()){
            if(numCnt.get(num) != maxCnt) continue;
            minLen = Math.min(minLen,numEnd.get(num) - numStart.get(num) + 1);
        }
        return minLen;
    }

}
