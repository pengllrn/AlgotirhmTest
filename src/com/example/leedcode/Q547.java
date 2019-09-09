package com.example.leedcode;

public class Q547 {
    public static void main(String[] args) {
        int circleNum = new Solution547_2().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(circleNum);
    }
}

//朋友圈
class Solution547 {
    private int n;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        n = M.length;
        boolean[] hasVisted = new boolean[n];
        int circles = 0;
        for (int i = 0; i < n; i++) {
            if (!hasVisted[i]) {
                circles++;//自己是一个独立的朋友圈
                dfs(M, i, hasVisted);//遍历i的朋友圈
            }
        }
        return circles;
    }

    private void dfs(int[][] M, int k, boolean[] hasVisted) {
        hasVisted[k] = true;
        for (int i = 0; i < n; i++) {//k与哪些人认识，都把它标记，这样他们就不是一个独立的朋友圈了
            if(M[k][i] == 1 && !hasVisted[i])
                dfs(M,i,hasVisted);
        }
    }
}

class Solution547_2 {
    public int findCircleNum(int[][] M){
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int len = M.length;
        int[] friend = new int[len];
        for (int i = 0; i < len; i++){
            friend[i] = i;
        }
        int group = len;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if(M[i][j] == 1){
                    int gi = find(friend, i);
                    int gj = find(friend, j);
                    if(gi != gj){
                        group--;
                        friend[gj] = gi;
                    }
                }
            }
        }
        return group;
    }
    private int find(int[] friend, int i){
        return friend[i] == i ? i : find(friend, friend[i]);
    }
}