package com.example.leedcode;

public class Q665 {
    public static void main(String[] args) {
        boolean b = new Possibility().checkPossibility(new int[]{4, 2, 3, 2});
        System.out.println(b);
    }
}

/**
 * 4,2,3,4 true
 * 3,4,2,3 false
 * 4, 2, 3,2 false
 * 2,3,3,2,4 true
 */
class Possibility {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            cnt++;
            if (i >= 2 && nums[i] < nums[i-2])
                nums[i] = nums[i - 1];
            else//nums[i] < nums[i-1]
                nums[i - 1] = nums[i];
        }
        return cnt <= 1;
    }

}