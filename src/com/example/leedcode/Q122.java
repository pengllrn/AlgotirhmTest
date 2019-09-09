package com.example.leedcode;

public class Q122 {
}

class SaleStock{

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1)
            return 0;
        int cnt = 0;
        int minPrice = prices[0];
        for (int i = 1;i<prices.length;i++){
            if(prices[i] < prices[i-1]){
                cnt += prices[i-1] - minPrice;
                minPrice = prices[i];
            }
        }
        return cnt+prices[prices.length - 1] - minPrice;
    }
}
