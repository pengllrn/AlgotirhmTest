package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 21:04</pre>
 */
public class Q318 {
    public static void main(String[] args) {
        int i = new Solution318_2().maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"});
        System.out.println(i);
    }
}

/**
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 */
class Solution318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1)
            return 0;
        boolean[][] bio = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            bio[i] = convert(words[i]);
        }
        int maxAns = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isXor(bio[i], bio[j]) || maxAns >= words[i].length() * words[j].length())
                    continue;
                maxAns = words[i].length() * words[j].length();
            }
        }
        return maxAns;
    }

    private boolean[] convert(String word) {
        boolean[] place = new boolean[26];
        for (char c : word.toCharArray())
            place[c - 'a'] = true;
        return place;
    }

    private boolean isXor(boolean[] b1, boolean[] b2) {
        for (int i = 0; i < 26; i++) {
            if (b1[i] && b2[i])
                return true;
        }
        return false;
    }
}

class Solution318_2{
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1)
            return 0;
        int n = words.length;
        int[] val = new int[n];
        for (int i = 0;i< n;i++){
            for (char c : words[i].toCharArray()){
                val[i] |= 1 << (c - 'a');
            }
        }
        int maxAns = 0;
        for (int i = 0;i<n;i++){
            for (int j = i + 1;j<n;j++){
                if((val[i] & val[j]) == 0)
                    maxAns = Math.max(maxAns,words[i].length() * words[j].length());
            }
        }
        return maxAns;
    }
}
