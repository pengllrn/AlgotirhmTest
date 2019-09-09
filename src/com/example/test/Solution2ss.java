package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/6 11:27</pre>
 */
public class Solution2ss {
    public int StrToInt(String str) {
        char f = str.charAt(0);
        boolean flag = true;
        int start = 0;
        if(f == '+' || f == '-'){
            flag = f != '-';
            start = 1;
        }
        int ans = 0;
        for(int i = start; i < str.length(); i++){
            char c = str.charAt(i);
            if(ans == 0 && c == '0')
                return 0;
            else if(c <= '9' && c >= '0'){
                int pre = ans;
                ans = ans * 10 + c - '0';//8
                if((ans - c + '0') / 10 != pre) return 0;
            }else
                return 0;
        }
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        int i = new Solution2ss().StrToInt("8j");
        System.out.println(i);
    }

}
