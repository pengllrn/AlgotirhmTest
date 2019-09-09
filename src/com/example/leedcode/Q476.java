package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 20:35</pre>
 */
public class Q476 {
    public static void main(String[] args) {
        System.out.println(1<<30);
        int complement = new Solution476().findComplement(1<<30);
        System.out.println(complement);
    }
}

class Solution476{
    public int findComplement(int num) {
        if(num == 0) return 1;
        int d = 0;
        int n = num;
        while (num != 0){
            d <<= 1;
            d |= 1;
            num >>>= 1;
        }
        return d ^ n;
    }
}

class Solution476_2{
    public int findComplement(int num){
        if(num == 0) return 1;
        int mask = 1 << 30;
        while ((mask & num) == 0) mask >>= 1;
        mask = (mask << 1) - 1;
        return mask ^ num;
    }
}
