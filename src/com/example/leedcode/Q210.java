package com.example.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Pengllrn
 * @since <pre>2019/6/27 13:18</pre>
 */
public class Q210 {
    public static void main(String[] args) {
        int[] order = new Solution210().findOrder(4, new int[][]{{3, 0}, {3, 1}, {3, 2}, {0, 2},{2,1}});
        System.out.println(Arrays.toString(order));
    }
}

class Solution210{
    private Queue<Integer> queue = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0)
            return new int[]{};
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0;i<numCourses;i++)
            graphic[i] = new ArrayList<>();
        for (int[] pre : prerequisites)
            graphic[pre[0]].add(pre[1]);
        queue = new LinkedList<>();
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for (int i = 0;i<numCourses;i++){
            if(hasCycle(graphic,globalMarked,localMarked,i))
                return new int[]{};
        }
        int[] ans = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty())
            ans[i++] = queue.poll();
        return ans;
    }

    private boolean hasCycle(List<Integer>[] graphic,boolean[] globalMarked,boolean[] localMarked,int index){
        if(localMarked[index])
            return true;
        if(globalMarked[index])
            return false;
        localMarked[index] = true;
        globalMarked[index] = true;
        if(graphic[index].size() != 0) {
            for (int g : graphic[index]) {
                if (hasCycle(graphic, globalMarked, localMarked, g))
                    return true;
            }
        }
        queue.add(index);
        localMarked[index] = false;
        return false;
    }
}