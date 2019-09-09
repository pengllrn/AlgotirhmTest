package com.example.leedcode;

public class Q345 {
    public static void main(String[] args) {
        String au = new ReverseVowels().reverse("au");
        System.out.println(au);
    }
}

/**
 * 反转元音字母出现的位置
 * 如 hello -->holle
 * Au-->uA
 */
class ReverseVowels {

    public String reverse(String s) {
        if (s == null || s.length() < 1)
            return s;
        char[] sArray = s.toCharArray();
        int left = 0;
        int right = sArray.length - 1;
        while (left < right){
            while (left<right && !isVowels(sArray[left]))
                left++;
            while (right > left && !isVowels(sArray[right]))
                right--;
            if(left != right) {
                swap(sArray, left, right);
                left++;
                right--;
            }
        }
        return new String(sArray);
    }

    private boolean isVowels(char c1){
        char c = Character.toLowerCase(c1);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
