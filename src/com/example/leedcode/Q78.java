package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution78_2().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}

class Solution78 {//传统思路：回溯法

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return ans;
        for (int i = 1; i <= nums.length; i++) {
            backtrack(ans, nums, new LinkedList<>(), i, 0);
        }
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> combine, int len, int start) {
        if (len == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            combine.add(nums[i]);
            backtrack(ans, nums, combine, len - 1, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}

class Solution78_2 {//叠加法 ————效率更高，一个不错的思路

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return ans;
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(ans.get(j));
                subset.add(nums[i]);
                ans.add(subset);
            }
        }
        return ans;
    }
}