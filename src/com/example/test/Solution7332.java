package com.example.test;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 19:37</pre>
 */
public class Solution7332 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum < 3)
            return ans;
        int start = 1;
        int tmp = 1;
        for (int end = 2; start <= sum / 2; ) {//<=7
            if (tmp < sum) {
                tmp += end++;
            } else {
                if (tmp == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = start; i < end; i++) {
                        list.add(i);
                    }
                    ans.add(list);
                }
                tmp -= start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new Solution7332().FindContinuousSequence(9);
        for (ArrayList<Integer> list : arrayLists)
            System.out.println(list);
    }
}
