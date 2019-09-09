package com.example.pdd;

/**
 * @author Pengllrn
 * @since <pre>2019/8/22 15:35</pre>
 */
public class Main1 {
    public int swamArray(int[] nums){
        if(nums == null || nums.length < 1)
            return 0;
        int n = nums.length;
        int prev = 1;
        int ans = 0;
        int tend = 1;//up:1 down:-1
        for (int i = 1; i < n; i++){
            int curT = Integer.compare(nums[i], nums[i - 1]);
            if(curT == tend){
                prev = prev + 1;
                tend = - tend;
                ans = Math.max(ans, prev);
            }else if(curT == 1){//tend = -1
                prev = 2;
            }else {
                tend = 1;
                prev = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Main1().swamArray(new int[]{4,6,6,7});
        System.out.println(i);
    }
}
