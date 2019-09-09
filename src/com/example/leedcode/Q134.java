package com.example.leedcode;

public class Q134 {
    public static void main(String[] args) {
        int i = new Solution134().canCompleteCircuit(new int[]{2, 3, 5,4,2}, new int[]{3, 1, 6,3,1});
        System.out.println(i);
    }
}

class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 && cost.length == 0)
            return -1;
        int len = cost.length;
        for (int i = 0; i < len; i++) {
            cost[i] = gas[i] - cost[i];
        }
        int total = 0;
        int index = 0;
        int rest = 0;
        for (int i = 0; i < len; i++) {
            total += cost[i];
            rest += cost[i];
            if(rest < 0){
                rest = 0;
                index = i + 1;
            }
        }
        return total < 0 ? -1 : index;
    }
}
