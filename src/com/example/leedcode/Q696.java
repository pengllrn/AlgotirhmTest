package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/21 11:18</pre>
 */
public class Q696 {
}

class Solution696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int preLen = 0, curLen = 1, cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1))
                curLen++;
            else {
                preLen = curLen;
                curLen = 1;
            }
            if(preLen >= curLen)
                cnt++;
        }
        return cnt;
    }
}
