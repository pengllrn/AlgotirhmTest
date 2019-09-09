package com.example.test;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 8:46</pre>
 */
public class Solution39 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (array == null || array.length == 0)
            return ans;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int s = array[left] + array[right];
            if (s == sum) {
                if (ans.isEmpty() || ((ans.get(1) + 0.0) / array[left] * (ans.get(0) + 0.0) / array[right]) > 1.0) {
                    ans.clear();
                    ans.add(array[left]);
                    ans.add(array[right]);
                }
                left++;
            } else if (s < sum) {
                left++;
            } else
                right--;
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new Solution39().FindNumbersWithSum(new int[]{1, 2, 3, 5, 7, 8}, 10);
        System.out.println(arrayList);
    }
}
