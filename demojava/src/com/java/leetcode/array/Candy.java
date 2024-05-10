package com.java.leetcode.array;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        int[] candies = new int[ratings.length];

        Arrays.fill(candies, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                candies[i - 1] =  Math.max(candies[i - 1], candies[i] + 1);
            }
        }
       return  Arrays.stream(candies).sum();
    }

    // Time cost is lower
    public int candy_2(int[] ratings) {
        if(ratings.length == 0) return 0;
        int[] candies = new int[ratings.length];

        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                candies[i - 1] =  Math.max(candies[i - 1], candies[i] + 1);
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
