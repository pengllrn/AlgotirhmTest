package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 9:22</pre>
 */
public class Solution26da {
    public String ReverseSentence(String str) {
        if(str == null || str.length() <= 1)
            return str;
        char[] arr = str.toCharArray();
        int p = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == ' '){
                rotate(arr, p, i - 1);
                p = i + 1;
            }
        }
        rotate(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for(char c : arr)
            sb.append(c);
        return sb.toString();
    }

    private void rotate(char[] arr, int l, int h){
        while(l < h){
            char c = arr[l];
            arr[l] = arr[h];
            arr[h] = c;
            l++;
            h--;
        }
    }

    public static void main(String[] args) {
        String s = new Solution26da().ReverseSentence("I am a student.");
        System.out.println(s);
    }
}
