package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 9:07</pre>
 */
public class Solution222 {
    public String LeftRotateString(String str,int n) {//cbafedZYX  XYZdefabc 原地反转
        if(str == null || n < 0 || n > str.length())
            return "";
        int len = str.length();
        char[] arr = new char[len];
        int idx = 0;
        for(int i = n; i < len; i++){
            arr[idx++] = str.charAt(i);
        }
        for(int i = 0; i < n; i++){
            arr[idx++] = str.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String abcXYZdef = new Solution222().LeftRotateString("abcXYZdef", 3);
        System.out.println(abcXYZdef);
    }
}
