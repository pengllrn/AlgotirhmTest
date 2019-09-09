package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q93 {
    public static void main(String[] args) {
        List<String> strings = new Solution93_2().restoreIpAddresses("111000");
        System.out.println(strings);
    }
}

/**
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
class Solution93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4)
            return ans;
        doRestore(0, ans, new StringBuilder(), s);
        return ans;
    }

    private void doRestore(int k, List<String> ans, StringBuilder prefix, String s) {
        int tempLen = prefix.length();
        if (k == 4 || tempLen == s.length() + 4) {//如果已经是4段了，则不能再分了，递归终止
            if (k == 4 && tempLen == s.length() + 4)//检查是否合法
                ans.add(prefix.toString().substring(0, prefix.length() - 1));//去掉最后一个点
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (tempLen + i + 1 - k > s.length())//超出不满足
                continue;
            String temp = s.substring(tempLen - k, tempLen + i + 1 - k);
            if (i > 0 && (Integer.valueOf(temp) > 255 || Integer.valueOf(temp) < Math.pow(10, i)))
                continue;
            prefix.append(temp);
            prefix.append(".");
            doRestore(k + 1, ans, prefix, s);
            prefix.delete(tempLen, tempLen + i + 2);
        }
    }
}

class Solution93_2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4)
            return ans;
        doRestore(0, ans, new StringBuilder(), s);
        return ans;
    }

    private void doRestore(int k, List<String> ans, StringBuilder prefix, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0)
                ans.add(prefix.toString());
            return;
        }
        for (int i = 0; i < s.length() && i < 3; i++) {//最多3次
            String part = s.substring(0, i + 1);
            if (i > 0 && (Integer.valueOf(part) > 255 || Integer.valueOf(part) < Math.pow(10, i)))
                continue;
            if (k != 0)
                part = "." + part;
            prefix.append(part);
            doRestore(k + 1, ans, prefix, s.substring(i + 1));
            prefix.delete(prefix.length() - part.length(), prefix.length());
        }
    }
}
