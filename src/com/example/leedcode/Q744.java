package com.example.leedcode;

public class Q744 {
    public static void main(String[] args) {
        char z = new Solution744().nextGreatestLetter(new char[]{'a','b','b','b'}, 'a');
        System.out.println(z);
    }
}

class Solution744{
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters == null || letters.length < 2)
            return ' ';
        int left = 0;
        int right = letters.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
