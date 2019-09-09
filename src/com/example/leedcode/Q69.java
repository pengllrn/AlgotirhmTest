package com.example.leedcode;

public class Q69 {
    public static void main(String[] args) {
        int i = new Solution69().mySqrt(16);
        System.out.println(i);
    }
}

class Solution69 {

    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int small = 1;
        int larger = 2;
        while (x / larger >= larger) {
            if (larger * larger == x)
                return larger;
            small = larger;
            larger = larger << 1;
        }
        while (small < larger) {
            int mid = small + (larger - small + 1) / 2;
            if (mid * mid == x)
                return mid;
            else if (x / mid >= mid) {
                small = mid;
            } else
                larger = mid - 1;
        }
        return small;
    }
}
