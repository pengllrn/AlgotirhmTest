package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/8/20 21:29</pre>
 */
public class Q12 {
    public static void main(String[] args) {
        String s = new SolutionQ12().intToRoman(58);
        System.out.println(s);
    }
}

class SolutionQ12 {
    private int[] w = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private String[] key = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            int idx = binarySearch(num);
            num = num - w[idx];
            sb.append(key[idx]);
        }
        return sb.toString();
    }

    private int binarySearch(int num){
        int left = 0, right = w.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if(w[mid] == num) return mid;
            else if(w[mid] < num){
                left = mid;
            }else
                right = mid - 1;
        }
        return left;
    }
}
