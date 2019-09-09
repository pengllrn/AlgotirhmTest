package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}

class Solution40 {
    private boolean[] marked;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        marked = new boolean[candidates.length];
        backtrack(ans, candidates, target, new LinkedList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> combine, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if(i != 0 && candidates[i] == candidates[i-1] && !marked[i-1])
                continue;
            marked[i] = true;
            combine.add(candidates[i]);
            backtrack(ans, candidates, target - candidates[i], combine, i + 1);
            combine.remove(combine.size() - 1);
            marked[i] = false;
        }
    }
}
