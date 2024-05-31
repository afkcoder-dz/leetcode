package com.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int n : nums) {
            if (!permutation.contains(n)) {
                permutation.add(n);
                backtrack(nums, permutation, result);
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        System.out.println(test.permute(new int[]{1,2,3}));
        System.out.println(test.permute(new int[]{0,1}));
        System.out.println(test.permute(new int[]{1}));
    }



    // Time complexity, what you should say in an interview: O(n⋅n!)
// For each of the n! permutations, we need O(n) work to copy curr into the answer.
// This gives us O(n⋅n!) work.

    // Two variations:
// 1. length of k: replace list.size() == nums.length with k
// 2. number can be reused: remove visited[i] check
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
            return res;
        }
        private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    list.add(nums[i]);
                    visited[i] = true;
                    helper(nums, res, list, visited);
                    list.remove(list.size() - 1); // backtracking
                    visited[i] = false; // backtracking
                }
            }
        }
    }
}
