package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 15:28</pre>
 */
public class Q461 {
    public static void main(String[] args) {
        int i = new Solution461().hammingDistance(-392343, 3289484);
        System.out.println(i);
    }
}

class Solution461{
    public int hammingDistance(int x, int y) {
        int v = x ^ y;
        int cnt = 0;
        while (v != 0){
            cnt++;
            v = v & (v - 1);
        }
        return cnt;
    }
}
