package com.example.leedcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/22 14:38</pre>
 */
public class Q378 {
}

/**
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 14],
 * [12, 13, 15]
 * ],
 * k = 8,
 */
class Solution378 {//堆解法
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {//每一列的第一个元素
            queue.add(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = queue.poll();
            if(t.x + 1 == row) continue;
            queue.add(new Tuple(t.x + 1,t.y,matrix[t.x + 1][t.y]));
        }

        return queue.poll().val;
    }

    class Tuple implements Comparable<Tuple>{
        int x, y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}

class Solution378_2{//二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for (int[] mat : matrix) {
                while (j >= 0 && mat[j] > mid) j--;//还可以继续使用二分优化
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
