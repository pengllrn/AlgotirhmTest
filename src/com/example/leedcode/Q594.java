package com.example.leedcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Pengllrn
 * @since <pre>2019/6/25 9:18</pre>
 */
public class Q594 {
    public static void main(String[] args) {
        int lhs = new Solution594_2().findLHS(new int[]{1,3,2,2,5,5,2,3,7,7,7,7});
        System.out.println(lhs);
    }
}

class Solution594{//字典
    public int findLHS(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;
        Map<Integer,Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0) + 1);
        int maxLen = 0;
        for (int num : map.keySet()){
            if(map.containsKey(num - 1)){
                maxLen = Math.max(maxLen,map.get(num - 1) + map.get(num));
            }
        }
        return maxLen;
    }
}

class Solution594_2{
    public int findLHS(int[] nums){
        if(nums == null || nums.length <= 1)
            return 0;
        Arrays.sort(nums);
        int preLength = 0;
        int curLength = 1;
        int maxLength = 0;
        for (int i = 1;i<nums.length - 1;i++){
            if(nums[i] == nums[i-1])
                curLength++;
            else if(nums[i] == nums[i- 1] + 1){
                preLength = curLength;
                curLength = 1;
            }else {//最大小值差超过了1，重置
                preLength = 0;
                curLength = 1;
            }
            if(preLength != 0 && curLength + preLength > maxLength)//必须是最大最小值相差1
                maxLength = curLength + preLength;
        }
        return maxLength;
    }
}