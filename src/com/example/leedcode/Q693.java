package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 19:18</pre>
 */
public class Q693 {
    public static void main(String[] args) {
        boolean b = new Solution693().hasAlternatingBits(1);
        System.out.println(b);
    }
}

class Solution693{
    public boolean hasAlternatingBits(int n) {
        int diff = n >> 1;
        int ret = n & ((diff ^ n) + 1 );
        return ret == 0;
    }
}
