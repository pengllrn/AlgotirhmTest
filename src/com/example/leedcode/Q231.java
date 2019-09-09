package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 19:12</pre>
 */
public class Q231 {
    public static void main(String[] args) {
        boolean powerOfTwo = new Solution231().isPowerOfTwo(1 << 30);
        System.out.println(powerOfTwo);
    }
}

/**
 * 输入: 218
 * 输出: false
 * 位运算
 */
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
