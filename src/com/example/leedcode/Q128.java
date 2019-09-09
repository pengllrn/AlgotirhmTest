package com.example.leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Pengllrn
 * @since <pre>2019/6/25 10:00</pre>
 */
public class Q128 {
    public static void main(String[] args) {
        int[] test = new int[10001];
        for (int i = 10000; i > 0; i--) {
            test[i] = i - 1000;
        }
        int i = new Solution128_2().longestConsecutive(test);
        System.out.println(i);
    }
}

/**
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> originSet = new HashSet<>();
        for (int num : nums)
            originSet.add(num);
        Map<Integer, List<Integer>> map = new HashMap<>();
        Integer[] arrays = originSet.toArray(new Integer[]{});
        for (int i = 0; i < arrays.length; i++) {
            if (!originSet.contains(arrays[i]))//已经遍历了
                continue;
            int val = arrays[i];
            List<Integer> list = new ArrayList<>();
            while (originSet.contains(val)) {
                originSet.remove(val);
                list.add(val);
                val = val - 1;
            }
            if (map.containsKey(val)) {//看是否可以拼接
                list.addAll(map.get(val));
                map.remove(val);
            }
            map.put(arrays[i], list);
        }
        int max = 0;
        for (int key : map.keySet()) {
            int size = map.get(key).size();
            max = Math.max(size, max);
        }
        return max;
    }
}

class Solution128_2{
    public int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num,0);
        for (int num : nums){
            forward(map,num);
        }
        int max = 0;
        for (int key : map.keySet()){
            max = Math.max(map.get(key),max);
        }
        return max;
    }

    private int forward(Map<Integer, Integer> map, int num) {
        if(!map.containsKey(num))
            return 0;
        int cnt = map.get(num);
        if(cnt >= 1)
            return cnt;
        cnt = forward(map,num - 1) + 1;
        map.put(num,cnt);
        return cnt;
    }
}
