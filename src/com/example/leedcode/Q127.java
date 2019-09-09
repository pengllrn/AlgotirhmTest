package com.example.leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q127 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = new LadderWord().ladderLength("hit", "dot", wordList);
        System.out.println(i);
    }
}

class LadderWord {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                String cur = queue.poll();
                wordList.remove(cur);//删除前一层的元素
                if(cur.equals(endWord))
                    return path;
                for (String s : wordList){
                    if(isConnected(cur,s) == 1 && !queue.contains(s)) {//当前层元素不重复
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }

    private int isConnected(String a, String b) {
        int len = a.length() - 1;
        int flag = 0;
        while (len >= 0 && flag < 2) {
            if (a.charAt(len) != b.charAt(len))
                flag ++;
            len--;
        }
        return flag;//0:same , 1:canConnect , >1失败
    }
}