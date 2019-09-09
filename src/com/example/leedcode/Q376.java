package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/8 20:43</pre>
 */
public class Q376 {
    public static void main(String[] args) {
        int i = new Solution376().wiggleMaxLength(new int[]{1, 1, 7, 4, 9, 2, 5});
        System.out.println(i);
    }
}

//[1,1,7,4,9,2,5]
class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1])
                down = up + 1;
            else if(nums[i] > nums[i-1])
                up = down + 1;
        }
        return Math.max(up,down);
    }
}
