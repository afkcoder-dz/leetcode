package com.java.leetcode.dp;

import java.util.Arrays;

public class ClimbingStairs {

    // time complexity O(n), space complexity O(1)
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;

        }
        return prev2;
    }

    // time complexity O(n), space complexity O(n)
    public int climbStairs1(int n) {
        if (n <= 2) return n;

        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];
    }

    // This uses straightforward recursion but is inefficient for large n due to repeated calculations.
    // exponential time complexity
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    // Backtracking
    // time complexity: O(n) (memoization ensures each step is solved once).
    // Transitions per State:O(1) (add results from n−1 and n−2).
    // Overall Time Complexity:O(n).

    // Space Complexity
    // Memoization Array: O(n).
    // Recursion Stack: O(n) in the worst case (for the depth of recursion).
    public int climbStairs3(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        return backtrack(n, memo);
    }

    private int backtrack(int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != 0) {
            return memo[target];
        }

        memo[target] = backtrack(target - 1, memo) + backtrack(target - 2, memo);
        return memo[target];
    }

    /**
     * Conclusion
     * Backtracking with Memoization: Easy to implement and suitable for small n.
     * Iterative DP: Better space efficiency for larger n
     */

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs(5));
        System.out.println(test.climbStairs1(5));
        System.out.println(test.climbStairs3(5));
    }

}
