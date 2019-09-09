package com.example.huawei;

import java.util.Scanner;

/**
 * @author Pengllrn
 * @since <pre>2019/8/21 19:01</pre>
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.split(" ");
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++){
            sb.append(trans(nums[i])).append(" ");
        }
        String res = sb.toString();
        String[] result = res.split(" ");
        int len = result.length + 1;
        System.out.print(transInt(len));
        System.out.println(" " + res);
    }

    private static String trans(String s){
        if("A".equals(s) || "0A".equals(s) || "0x0A".equals(s)){
            return "12 34";
        }else if("B".equals(s) || "0B".equals(s) || "0x0B".equals(s)){
            return "AB CD";
        }else
            return s;
    }

    private static String transInt(int n){
        if(n < 10){
            return "" + n;
        }if(n < 16){
            char c = (char) ('A' + n - 10);
            return "" + c;
        }else {
            int h = n / 16;
            int l = n - h * 16;
            return transInt(h) + transInt(l);
        }
    }

}
