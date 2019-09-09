package com.example.leedcode;

import java.util.Arrays;

/**
 * @author Pengllrn
 * @since <pre>2019/6/28 15:20</pre>
 */
public class Q338 {
    public static void main(String[] args) {
        int[] ints = new Solution338().countBits(5);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution338 {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ret[i] = ret[i & (i -1)] + 1;
        }
        return ret;
    }
}
