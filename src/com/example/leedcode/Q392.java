package com.example.leedcode;

import java.util.ArrayList;

public class Q392 {
    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        subsequence.init("dhsuahdsia");
        for (int i = 0; i < 100000000; i++) {
            boolean abc = subsequence.judge("leeeeetcode");
        }
    }
}

class Subsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }


    private ArrayList<ArrayList<Integer>> record;

    public void init(String t) {
        record = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            record.add(new ArrayList<>());
        }
        if (t == null) return;
        int index = 0;
        for (char c : t.toCharArray()) {
            ArrayList<Integer> list = record.get(c - 'a');
            list.add(index++);
        }
    }

    public boolean judge(String s) {
        if (s == null)
            return false;
        int curIndex = -1;
        for (char c : s.toCharArray()) {
            ArrayList<Integer> list = record.get(c - 'a');
            int findIndex = findIndex(list, curIndex);
            if (findIndex == -1)
                return false;
            curIndex = list.get(findIndex);
        }
        return true;
    }

    /**
     * 找到给定list中,第一个大于value值的坐标
     * list为顺序列表
     * 二分查找
     *
     * @param list
     * @return
     */
    private int findIndex(ArrayList<Integer> list, int value) {
        if (list.size() == 0)
            return -1;
        if (list.size() == 1)
            return list.get(0) > value ? 0 : -1;
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= value)
                left = mid + 1;
            else
                right = mid;
        }
        return right == list.size() ? -1 : right;
    }
}
