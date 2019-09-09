package com.example.leedcode;

public class Q167 {
}

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
 */
class SumOfTwoNumber{

    public int[] twoSum(int[] numbers,int target){
        if(numbers == null || numbers.length <2)
            return new int[]{};
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex){
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if(sum == target)
                break;
            if(sum < target)
                leftIndex++;
            else
                rightIndex--;
        }
        if(leftIndex == rightIndex)
            return new int[]{};
        int[] result = new int[2];
        result[0] = leftIndex+1;
        result[1] = rightIndex+1;
        return (numbers[leftIndex]+ numbers[rightIndex] == target)?result:new int[]{};
    }
}
