package com.java.leetcode.array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{3,2,6,5,0,3};
        int[] prices3 = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }


    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        int buyDayIndex;
        int sellDayIndex;
        for (int i = 0; i < prices.length - 1; i++) {
            buyDayIndex = i;
            sellDayIndex = i;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[sellDayIndex]) {
                    sellDayIndex = j;
                }
            }
            if (profit < prices[sellDayIndex] - prices[buyDayIndex]) {
                profit = prices[sellDayIndex] - prices[buyDayIndex];
            }
        }
        return profit;
    }
}
