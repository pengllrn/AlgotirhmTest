package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution90_2().subsetsWithDup(new int[]{1, 2, 2, 2, 1});
        System.out.println(lists);
    }
}

class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            backtrack(ans, nums, new LinkedList<>(), new boolean[nums.length], 0, i);
        }
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> combine, boolean[] marked, int start, int len) {
        if (len == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i < nums.length && i <= nums.length - len + 1; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && !marked[i - 1])
                continue;
            marked[i] = true;
            combine.add(nums[i]);
            backtrack(ans, nums, combine, marked, i + 1, len - 1);
            combine.remove(combine.size() - 1);
            marked[i] = false;
        }
    }
}

class Solution90_2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> combine = new ArrayList<>(ans.get(j));
                if (i != 0 && nums[i - 1] == nums[i]) {
                    if (combine.size() == 0 || combine.get(combine.size() - 1) != nums[i])
                        continue;
                }
                combine.add(nums[i]);
                ans.add(combine);
            }
        }
        return ans;
    }
}


