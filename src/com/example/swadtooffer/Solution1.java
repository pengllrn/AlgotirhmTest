package com.example.swadtooffer;

/**
 * @author Pengllrn
 * @since <pre>2019/7/28 8:40</pre>
 */
public class Solution1 {
    public double Power(double base, int exponent) {
        if(base == 0.0) return 0.0;
        if(exponent == 0) return 1.0;
        boolean flag = exponent < 0;
        if(flag) exponent = 0 - exponent;
        double ans = 1;
        while(exponent != 0){
            if((exponent & 1) != 0)
                ans *= base;
            base = base * base;
            exponent = exponent >> 1;
        }
        StringBuilder sb = new StringBuilder();
        return flag ? 1 / ans : ans;
    }

    public static void main(String[] args) {
        double power = new Solution1().Power(2, 3);
        System.out.println(power);
    }
}
