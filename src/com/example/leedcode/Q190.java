package com.example.leedcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 17:04</pre>
 */
public class Q190 {
    public static void main(String[] args) {

        byte b = 1;
        for (int i = 0;i<8;i++){
            b <<= 1;
            System.out.println(b);
        }

        int i = new Solution190_cache().reverseBits(-3);
        System.out.println(i);
    }
}

/**
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 */
class Solution190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }
        return ans;
    }
}

/**
 * 思考：为什么不能使用Byte   Map<Byte, Byte>
 *     byte : -128 (1000 0000)
 *     int : -128 (1111 1111 1111 1111 1111 1111 1000 0000‬)
 *     理想：-128（byte）--> -128(int) : 0000 0000 0000 0000 0000 0000 0000 0000 1000 0000
 *     实际并不一样
 */
class Solution190_cache {
    private Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans <<= 8;
            ans |= reverse((byte) (n & 0b11111111));//转int
            n >>>= 8;
        }
        return ans;
    }

    private int reverse(byte n) {
        if (cache.containsKey(n)) return cache.get(n);
        int ret = 0;//大容量保证转换为int时不错出
        byte b = n;
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>= 1;
        }
        cache.put(b,ret);
        return ret;
    }
}