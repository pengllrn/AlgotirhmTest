package com.example.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution46().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] marked = new boolean[nums.length];
        backtracking(ans, new LinkedList<>(), nums,marked);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> path, int[] nums,boolean[] marked) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i< nums.length;i++){
            if(marked[i])
                continue;
            marked[i] = true;
            path.add(nums[i]);
            backtracking(ans,path,nums,marked);
            path.remove(path.size() - 1);//删除最后一个元素即刚添加的元素
            marked[i] = false;
        }
    }
}
