package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution39_2().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, new LinkedList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> combine) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        int lastNumber = combine.size() == 0 ? candidates[0] : combine.get(combine.size() - 1);
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            //为了避免出现相同的组合，例如[2,3]和[3,2]，可以让组合按升序排列
            if (candidates[i] < lastNumber)
                continue;
            combine.add(candidates[i]);
            backtrack(ans, candidates, target - candidates[i], combine);
            combine.remove(combine.size() - 1);
        }
    }
}

class Solution39_2 {
    /**
     * @param candidates 数组元素都不能相同
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, new LinkedList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> combine, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        //为了避免出现相同的组合，例如[2,3]和[3,2]，可以让组合按升序排列
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            combine.add(candidates[i]);
            backtrack(ans, candidates, target - candidates[i], combine, i);
            combine.remove(combine.size() - 1);
        }
    }
}
