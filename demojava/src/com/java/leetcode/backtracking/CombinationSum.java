package com.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        backtrack(candidates,target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> combi, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combi));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i< candidates.length; i++) {  // i starts from start is used for avoiding duplicated paths
            combi.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, combi, result);
            combi.remove(combi.size() - 1);
        }
    }




        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            getResult(result, new ArrayList<Integer>(), candidates, target, 0);

            return result;
        }

        private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
            if(target > 0){
                for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                    cur.add(candidates[i]);
                    getResult(result, cur, candidates, target - candidates[i], i);
                    cur.remove(cur.size() - 1);
                }//for
            }//if
            else if(target == 0 ){
                result.add(new ArrayList<Integer>(cur));
            }//else if
        }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        System.out.println(test.combinationSum(new int[]{2,3,4,7}, 7));
        System.out.println(test.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(test.combinationSum(new int[]{2}, 1));
    }

}
