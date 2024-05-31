package com.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        // If the input is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        // Map for digit to letters mapping
        String[] mapping = {
                "",     // 0 (no mapping for 0)
                "",     // 1 (no mapping for 1)
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        backtrack(result, digits, mapping, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String digits, String[] mapping, int index, StringBuilder current) {
        // Base case: if the current combination length matches the input digits length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = mapping[digits.charAt(index) - '0'];

        // Iterate through each letter and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter);              // Add the letter to the current combination
            backtrack(result, digits, mapping, index + 1, current); // Recurse to the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last letter
        }
    }

    public static void main(String[] args) {
        // Test the functionx
        String digits = "234";
      //  List<String> combinations = letterCombinations(digits);
     //   System.out.println(combinations); // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        LetterCombinations test = new LetterCombinations();
        System.out.println(test.letterCombinations2(digits));
    }


    public List<String> letterCombinations2(String digits) {
        if(digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] mapping = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();
        backtrack2(digits, mapping, 0, "", result);

        return result;
    }

    public void backtrack2(String digits, String[] mapping, int index, String tempCombination, List<String> result){
        if(index == digits.length()){
            result.add(tempCombination);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for(char letter: letters.toCharArray()){
            backtrack2(digits, mapping, index + 1, tempCombination + letter, result);
        }
    }
}
