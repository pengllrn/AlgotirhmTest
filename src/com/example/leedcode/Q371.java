package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 20:50</pre>
 */
public class Q371 {
    public static void main(String[] args) {
        int sum = new Solution371().getSum(13, -14);
        System.out.println(sum);
    }
}

class Solution371{
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1) ;
    }
}
