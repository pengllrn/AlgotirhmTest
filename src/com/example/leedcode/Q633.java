package com.example.leedcode;

public class Q633 {
}

/**
 * 0:true
 * 1:true
 * 2:true  1+1;
 * 3:false
 * 4:true  0+2^2
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 两个整数可以一样，也可以是0
 */
class JudgeSquareSum{

    public boolean judge(int c){
        if(c < 0)
            return false;
        int right = (int )Math.sqrt(c);
        int left = 0;
        while (left <= right){
            int temp  = (int) (Math.pow(left,2) + Math.pow(right,2));
            if(temp == c)
                return true;
            if(temp < c)
                left++;
            else
                right--;
        }
        return false;
    }
}
