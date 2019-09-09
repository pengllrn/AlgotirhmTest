package com.example.leedcode;

public class Q5 {
    public static void main(String[] args) {
        String abc = new LongestSubPalindrome().longestPalindrome2("abaabad");
        System.out.println(abc);
    }
}

class LongestSubPalindrome {

    /**
     * 动态规划法
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];//dp[i][j]表示s[i..j]是否回文
        String res = "";
        for (int i = 0; i < s.length(); i++) {//i
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                //递推式
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 == i) dp[j][i] = true;//这种情况直接可以得出结论
                    else {
                        dp[j][i] = dp[j+ 1][i-1];
                    }
                    if (dp[j][i] && i - j + 1> res.length())
                        res = s.substring(j, i + 1);
                }
            }
        }
        return "".equals(res) ? "" + s.charAt(0) : res;
    }

    /**
     * 中心拓展法
     * @param s
     * @return
     */
    private String res = "";
    public String longestPalindrome2(String s){
        if (s == null || s.length() <= 1)
            return s;
        for (int i = 0;i<s.length();i++){
            judge(s,i,i);
            judge(s,i,i+1);
        }
        return res;
    }

    private void judge(String s,int start,int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            if(end - start + 1 > res.length())
                res = s.substring(start,end + 1);
            end++;
            start--;
        }
    }
}
