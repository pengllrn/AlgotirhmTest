package com.example.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution77().combine(6, 1);
        System.out.println(combine);
    }
}

class Solution77 {//使用剪枝

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1 || k > n)
            return ans;
        backtracking(ans, n, k, new LinkedList<>());
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int n, int k, List<Integer> combine) {
        if (k == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        int lastNumber = combine.size() == 0 ? 0 : combine.get(combine.size() - 1);
        for (int i = lastNumber + 1; i <= n - k + 1; i++) {//剪枝，左右剪枝，即缩小循环的起始和结束位置
            combine.add(i);
            backtracking(ans, n, k - 1, combine);//缩小k
            combine.remove(combine.size() - 1);
        }
    }
}

class Solution77_2 {//未使用剪枝

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 1 || k > n)
            return ans;
        backtracking(ans, n, k, new LinkedList<>());
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int n, int k, List<Integer> combine) {
        if (combine.size() == k) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        int lastNumber = combine.size() == 0 ? 0 : combine.get(combine.size() - 1);
        for (int i = lastNumber + 1; i <= n; i++) {
            combine.add(i);
            backtracking(ans, n, k, combine);
            combine.remove(combine.size() - 1);
        }
    }
}

class Solution77_3{
    public List<List<Integer>> combine(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
