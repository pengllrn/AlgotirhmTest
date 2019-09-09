package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/24 11:04</pre>
 */
public class Q769 {
    public static void main(String[] args) {
        int i = new Solution769().maxChunksToSorted(new int[]{1,3,0,4,2,6,5});
        System.out.println(i);
    }
}

class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxChunks = 0;
        int threshold = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold)
                threshold = arr[i];
            if (i == threshold)
                maxChunks++;
        }
        return maxChunks;
    }
}
