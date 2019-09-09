package com.example.tr;


/**
 * @author Pengllrn
 * @since <pre>2019/8/14 10:15</pre>
 */
public class Test {
    public static void main(String[] args) {
        String out = new Solution().convert("ABD", 1);
        System.out.println(out);
    }
}

class Solution {
    private int[][] derect = new int[][]{{1, 0}, {-1, 1}};
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1)
            return s;
        int n = s.length();
        int col = n / 2 + 1;
        char[][] z = new char[numRows][col];
        int cur = 0;
        int i = 0, j = 0;
        for(char c : s.toCharArray()){
            z[i][j] = c;
            int[] der = derect[cur % 2];
            i += der[0];
            j += der[1];
            if(i < 0 || i == numRows){
                i -= der[0];
                j -= der[1];
                cur++;
                der = derect[cur % 2];
                i += der[0];
                j += der[1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < numRows; x++){
            for(int y = 0; y < col; y++){
                if(z[x][y] == 0) continue;
                sb.append(z[x][y]);
            }
        }
        return sb.toString();
    }
}
