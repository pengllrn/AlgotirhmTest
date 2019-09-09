package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/8/20 22:07</pre>
 */
public class Q15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 0, 0, 0, -2, 0, 1, 1, 2};
        List<List<Integer>> lists = new Solution15().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

/**
 * [0，0，0]  [0，0，0，0] [-2, 0, 1 ,1 ,2]
 */
class Solution15 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {//在i之后的数中找两数之后等于-nums[i]
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, h = nums.length - 1;
            int target = 0 - nums[i];
            while (l < h) {
                int tmp = nums[l] + nums[h];
                if (tmp == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (++l < h && nums[l] == nums[l - 1]) ;
                    while (--h > l && nums[h] == nums[h + 1]) ;
                } else if (tmp < target) {
                    ++l;
                } else
                    --h;
            }
        }
        return ans;
    }
}
