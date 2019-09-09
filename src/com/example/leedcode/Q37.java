package com.example.leedcode;

import java.util.Arrays;

public class Q37 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'6','.','.','.','.','.','4','.','5'},
//                {'.','.','8','2','.','.','.','.','.'},
//                {'.','.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','.','6','.','1','.'},
//                {'4','.','7','.','.','.','.','.','.'},
//                {'.','.','.','1','.','.','.','2','.'},
//                {'.','.','6','.','.','.','7','8','.'},
//                {'.','.','.','.','5','4','.','.','.'},
//                {'.','.','.','9','.','.','.','.','.'}
//        };
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution37().solveSudoku(board);
        for (int i = 0 ;i<9;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}

class Solution37 {
    private char[][] board;
    private boolean[][] rowUsed = new boolean[9][9];
    private boolean[][] colUesd = new boolean[9][9];
    private boolean[][] cubeUsed = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rowUsed[i][c - '1'] = true;
                    colUesd[j][c - '1'] = true;
                    int index = (i / 3) * 3 + j / 3;//方块索引
                    cubeUsed[index][c - '1'] = true;
                }
            }
        }
        backtrack(0, 0);
    }

    private boolean backtrack(int r, int c) {
        while (r < 9 && board[r][c] != '.') {//从当前位置开始，直到找到一个空白的位置
            r = c == 8 ? r + 1 : r;//列为8的下一行为 行+1，否则不变
            c = c == 8 ? 0 : c + 1;//列为8的下一列为0，否则为c + 1;
        }

        if (r == 9) {//遍历结束
            return true;
        }
        boolean[] rest = restNumber(r, c);//当前剩余候选数字
        for (int i = 0; i < 9; i++) {
            if (rest[i]) {
                rowUsed[r][i] = true;
                colUesd[c][i] = true;
                cubeUsed[(r / 3) * 3 + c / 3][i] = true;
                board[r][c] = (char) (i + '1');
                if(backtrack(r ,c))//下一个目标。找到目标就要返回，否则又会修改掉board。仅当成功找到才返回
                    return true;
                rowUsed[r][i] = false;
                colUesd[c][i] = false;
                cubeUsed[(r / 3) * 3 + c / 3][i] = false;
                board[r][c] = '.';
            }
        }
        return false;
    }

    private boolean[] restNumber(int r, int c) {
        boolean[] rest = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (rowUsed[r][i] || colUesd[c][i] || cubeUsed[(r / 3) * 3 + c / 3][i])
                continue;
            rest[i] = true;
        }
        return rest;
    }
}
