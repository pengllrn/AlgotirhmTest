package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 10:41</pre>
 */
public class Q448 {
    public static void main(String[] args) {
        List<Integer> list = new Solution448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(list);
    }
}

//缺失的数据
////4,3,2,7,8,2,3,1      -4,-3,-2,-7,8,2,-3,-1
class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {//4,3,2,7,8,2,3,1   1,2,3,4,3,2,7,8
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                list.add(i + 1);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
