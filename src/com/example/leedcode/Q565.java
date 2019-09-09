package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/24 10:11</pre>
 */
public class Q565 {
    public static void main(String[] args) {
        int i = new SOlution565().arrayNesting(new int[]{2,1,3,4,5,6,0});
        System.out.println(i);
    }
}

class SOlution565{
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        boolean[] visited = new boolean[nums.length];
        int maxLen = 0;
        for (int i = 0;i<nums.length;i++){
            int curLen = 0;
            int cur = i;
            while (!visited[cur]){
                curLen++;
                visited[cur] = true;
                cur = nums[cur];
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}

