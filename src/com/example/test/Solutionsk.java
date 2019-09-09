package com.example.test;

import java.util.ArrayList;

/**
 * @author Pengllrn
 * @since <pre>2019/7/4 20:15</pre>
 */
public class Solutionsk {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(input == null || input.length == 0 || k <= 0 || k > input.length)
            return ans;
        int left = 0;
        int right = input.length - 1;
        while(true){
            int p = partition(input, left, right);
            if(p == k - 1)
                break;
            if(p < k - 1)
                left = p + 1;
            else
                right = p - 1;
        }
        for(int i = 0; i < k; i++)
            ans.add(input[i]);
        return ans;
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while(true){
            while(i != right && nums[++i] <= pivot);
            while(j != left && nums[--j] >= pivot);
            if(i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  =temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new Solutionsk().GetLeastNumbers_Solution(new int[]{4}, 1);
        System.out.println(arrayList);
    }
}
