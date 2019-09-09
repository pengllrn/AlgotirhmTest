package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/8/20 18:59</pre>
 */
public class Q8 {
    public static void main(String[] args) {
        int i = new Solution_8().myAtoi(" - 4334275984758934");
        System.out.println(i);
    }
}

class Solution_8{
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        String trim = str.trim();
        if(trim.length() == 0) return 0;
        char head = trim.charAt(0);
        boolean negative = false;
        if(head == '+' || head == '-'){
            negative = head == '-';
            trim = trim.substring(1);
        }
        if(trim.length() == 0) return 0;
        long ans = 0;
        for (int i = 0 ; i < trim.length(); i++){
            char c = trim.charAt(i);
            if(c > '9' || c < '0') return (int) (negative ? ans * -1 : ans);
            ans = ans * 10 + c - '0';
            if(!negative && ans > Integer.MAX_VALUE){
                ans = Integer.MAX_VALUE;
                break;
            }else if(negative && ans * (-1) < Integer.MIN_VALUE){
                ans = Integer.MIN_VALUE;
                break;
            }
        }
        return (int) (negative ? ans * -1 : ans);
    }
}
