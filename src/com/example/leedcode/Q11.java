package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/8/20 20:48</pre>
 */
public class Q11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,7,3,4,8,10,1000};
        int i = new Solution11().maxArea(arr);
        System.out.println(i);
    }
}

class Solution11{
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int ans = 0;
        int i = 0, j = height.length - 1;
        while (i < j){
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                i++;
            }else
                j--;
        }
        return ans;
    }
}
