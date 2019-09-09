package com.example.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution216().combinationSum3(3, 10);
        System.out.println(lists);
    }
}

class Solution216 {

    /**
     * @param k k个数
     * @param n 和
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > 10 || n < 6)
            return ans;
        backtrack(ans, k, n, new LinkedList<>(), 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int k, int target, List<Integer> combine, int start) {
        if (target == 0 || k == 0) {
            if (target == 0 && k == 0)
                ans.add(new ArrayList<>(combine));
            return;
        }

        for (int i = start; i < 10 && i <= target && i <= 10 - k + 1; i++) {
            combine.add(i);
            backtrack(ans, k - 1, target - i, combine, i + 1);//顺序性，start+1
            combine.remove(combine.size() - 1);
        }
    }
}
