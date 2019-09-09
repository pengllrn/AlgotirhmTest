package com.example.leedcode;

public class Q605 {
}

class Plaint {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed.length == 1)
            return flowerbed[0]==0;
        int cnt = 0;
        if(flowerbed[0] == 0 && flowerbed[1]==0){
            flowerbed[0] = 1;
            cnt++;
        }
        for (int i = 1;i<flowerbed.length;i++){
            if(flowerbed[i]==0 && flowerbed[i-1]==0){
                cnt++;
                flowerbed[i] = 1;
            }
            if(flowerbed[i]==1 && flowerbed[i-1]==1){
                cnt--;
            }
        }
        return cnt >= n;
    }
}
