package com.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k == 0) {
            return Collections.emptyList();
        }
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int n, int k, int start, List<Integer> combi, List<List<Integer>> result) {
        if (combi.size() == k) {
            result.add(new ArrayList<>(combi));
            return;
        }
        for (int i = start; i <= n; i++) {
            combi.add(i);
            backtrack(n, k, i + 1, combi, result);
            combi.remove(combi.size() - 1);
        }
    }


    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(4, 3));
    }

}
