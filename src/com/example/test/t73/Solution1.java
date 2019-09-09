package com.example.test.t73;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Pengllrn
 * @since <pre>2019/7/3 10:37</pre>
 */
public class Solution1 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence,int left,int right){
        if(left >= right)
            return true;
        int i = left;
        for(; i < right && sequence[i] <= sequence[right] ; i++){
        }
        int mid = i - 1;
        for( ; i < right ; i++){
            if(sequence[i] <= sequence[right])
                return false;
        }
        return verify(sequence, left, mid) && verify(sequence, mid + 1,right - 1);
    }

    public static void main(String[] args) {
        boolean b = new Solution1().VerifySquenceOfBST(new int[]{});
        System.out.println(b);
        ArrayList<Integer> list = new ArrayList<>();
    }
}

