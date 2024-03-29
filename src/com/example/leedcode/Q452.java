package com.example.leedcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
}

class QiQIu{

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = points[0][1];
        for(int i = 1;i<points.length;i++){
            if(points[i][0] <= end)
                continue;
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
