package com.example.leedcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pengllrn
 * @since <pre>2019/6/26 10:33</pre>
 */
public class Q207 {
    public static void main(String[] args) {
        boolean b = new Solution207().canFinish(2, new int[][]{{1, 0},{0,1}});
        System.out.println(b);
    }
}

/**
 * 回溯
 */
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        boolean[] localMarked = new boolean[numCourses];
        boolean[] globalMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graphic, localMarked, globalMarked, i))
                return false;
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] graphic, boolean[] localMarked, boolean[] globalMarked, int i) {
        if (localMarked[i])
            return true;
        if (globalMarked[i])
            return false;
        globalMarked[i] = true;
        localMarked[i] = true;
        for (int g : graphic[i]) {
            if (hasCycle(graphic, localMarked, globalMarked, g))
                return true;
        }
        localMarked[i] = false;
        return false;
    }


}
