package com.java.leetcode.dp;

public class HouseRobber {
    public int rob0(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = 0, prev2 = 0;

        for (int num : nums) {
            int current = Math.max(prev1, num + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        System.out.println(test.rob1(new int[]{1, 2, 3, 1}));
        System.out.println(test.rob1(new int[]{2, 7, 9, 3, 1}));
    }
}
