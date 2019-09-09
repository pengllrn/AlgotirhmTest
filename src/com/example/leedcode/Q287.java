package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/23 11:25</pre>
 */
public class Q287 {
    public static void main(String[] args) {
        int duplicate = new Solution287().findDuplicate(new int[]{3,2,1,3});
        System.out.println(duplicate);
    }
}

//[3,1,3,4,2]  3
class Solution287 {//二分查找法 O(nlogn)

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;//2   3
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(nums[i] <= mid)
                    cnt++;
            }
            if(cnt <= mid)//重复元素没在[1....mid]
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

class Solution287_2{
    public int findDuplicate(int[] nums){
        if(nums == null || nums.length ==0)
            return 0;
        int slow = nums[0],fast = nums[nums[0]];//共同的起点是0
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
