package com.java.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // Initialize dp array with a value larger than any possible solution
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Using amount + 1 as "infinity"
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Build up dp array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still "infinity", return -1 (impossible case)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // refined dynamic programing
    public int coinChange1(int[] coins, int amount) {
        // Initialize dp array with a value larger than any possible solution
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Using amount + 1 as "infinity"
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Build up dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // If dp[amount] is still "infinity", return -1 (impossible case)
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * Dynamic Programming vs. Backtracking:
     * Dynamic programming is a better approach because:
     * It systematically solves overlapping subproblems by storing intermediate results (memoization or tabulation).
     * It ensures that the solution is optimal by comparing all possible ways to make each amount iteratively.
     * It has a polynomial time complexity of O(amount⋅num_coins), compared to the exponential time complexity of backtracking.
     * <p>
     * Backtracking is useful in problems where:
     * <p>
     * You need all possible combinations rather than the optimal one.
     * The input size is small, so exhaustive search is computationally feasible.
     * For the coin change problem, the goal is to find the fewest number of coins, making backtracking an inefficient and unsuitable choice.
     */
    public int coinChange2(int[] coins, int amount) {
        // Memoization array to store minimum coins needed for each amount
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1); // -1 indicates the result for that amount has not been calculated yet

        // Start backtracking from the total amount
        int result = backtrack(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int backtrack(int[] coins, int amount, int[] memo) {
        // Base cases
        if (amount == 0) return 0; // No coins needed for amount 0
        if (amount < 0) return Integer.MAX_VALUE; // Invalid case

        // If already computed, return the memoized result
        if (memo[amount] != -1) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        // Try each coin and recurse for the remaining amount
        for (int coin : coins) {
            int result = backtrack(coins, amount - coin, memo);
            if (result != Integer.MAX_VALUE) { // Only consider valid results
                minCoins = Math.min(minCoins, result + 1); // Add 1 for the current coin
            }
        }

        // Memoize the result for the current amount
        memo[amount] = minCoins;
        return memo[amount];
    }

    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        System.out.println(test.coinChange2(new int[]{186, 419, 83, 408}, 409));
        System.out.println(test.coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(test.coinChange2(new int[]{2}, 3));
        System.out.println(test.coinChange(new int[]{1}, 0));
    }

}
