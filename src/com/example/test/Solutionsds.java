package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/5 16:15</pre>
 */
public class Solutionsds {
    private long cnt;
    private int[] aux;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        aux = new int[array.length];
        split(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void split(int[] array, int left, int right){
        if(right <= left)
            return;
        int mid = left + (right - left) / 2;
        split(array, left, mid);
        split(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            aux[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i > mid)
                nums[k] = aux[j++];
            else if(j > right)
                nums[k] = aux[i++];
            else if(aux[i] <= aux[j])
                nums[k] = aux[i++];
            else {//逆序
                cnt += mid - i + 1;
                nums[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int i = new Solutionsds().InversePairs(new int[]{3,2,1});
        System.out.println(i);
    }
}
