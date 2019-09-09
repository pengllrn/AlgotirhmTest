package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution47_2().permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}

class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] marked = new boolean[nums.length];
        backtracking(ans, new ArrayList<>(), nums, marked);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] marked) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (marked[i] || set.contains(nums[i]))//前面遍历过的不要；本轮已经相同的元素不遍历第二次
                continue;
            set.add(nums[i]);
            marked[i] = true;
            path.add(nums[i]);
            backtracking(ans, path, nums, marked);
            path.remove(path.size() - 1);//删除最后一个元素即刚添加的元素
            marked[i] = false;
        }
    }
}

class Solution47_2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] marked = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(ans, new ArrayList<>(), nums, marked);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] marked) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问(一轮)，那么就跳过这个元素。
            if (i != 0 && nums[i - 1] == nums[i] && !marked[i - 1])
                continue;
            if (marked[i])
                continue;
            marked[i] = true;
            path.add(nums[i]);
            backtracking(ans, path, nums, marked);
            path.remove(path.size() - 1);
            marked[i] = false;
        }
    }
}