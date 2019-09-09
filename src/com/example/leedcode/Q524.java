package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Q524 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ssss");
        String aaa = new LongestWord().findLongestWord("aaa", list);
        System.out.println(aaa);
    }
}

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
class LongestWord {

    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> o2.length() - o1.length());
        String longestWord = "";
        if (s == null || s.length() == 0)
            return longestWord;
        for (String string : d) {
            int len1 = string.length(), len2 = longestWord.length();
            if (len1 < len2 || (len1 == len2 && longestWord.compareTo(string) < 0))
                continue;
            if (isSubStr(s, string))
                longestWord = string;
        }

        return longestWord;
    }

    private boolean isSubStr(String s, String word) {
        int j = 0;
        int l = word.length() - 1;
        for (int i = 0; i < s.length() && j <= l; i++) {
            if (s.charAt(i) == word.charAt(j))
                j++;
        }
        return j == word.length();
    }

}
