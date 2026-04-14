package com.java.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicatedElementsInArray {

    public static void main(String[] args) {

        // int[] testArray = new int[] {0,0,1,1,1,1,2,3,3};
        // System.out.println(Arrays.toString(removeDuplicates(testArray)));

        String romaNum = "MCMXCIV";
        System.out.println(romanToInt(romaNum));


        System.out.println(lengthOfLastWord4(" dh  hello  "));

        String[] testStr = new String[] {"ab", "a"};
        System.out.println(longestCommonPrefix2(testStr));

    }


    public static int[] removeDuplicates(int[] nums) {
        int k = 1;
        int counter = 1;
        int m = 2;
        String s;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter <= m) {
                nums[k++] = nums[i];
            }
        }
        return nums;
    }


    public static int romanToInt(String s) {
        int val = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int prev = num;
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }

            if (num >= prev) {
                val += num;
            } else {
                val -= num;
            }
        }
        return val;
    }


    public static int lengthOfLastWord1(String s) {
        String[] ss = s.split(" ");
        if(ss.length == 0) {
            return 0;
        }
        String lastWord = ss[ss.length - 1];
        return lastWord.length();

    }

    public static int lengthOfLastWord2(String s) {
        String trimedString = s.trim();
        for (int i = trimedString.length() - 1; i >= 0; i--) {
            if (trimedString.charAt(i) == ' ') {
                return trimedString.length() - 1 - i;
            }
        }
        return trimedString.length();
    }

    public static int lengthOfLastWord3(String s) {
        // Consider if the string is very long, trim() method will traverse the string from both ends.
        // However we actually can only traverse the String from the back end.
        // Both trim() and lastIndexOf() will cost O(n) time complexity.
        String trimedString = s.trim();
        return trimedString.length() - 1 - trimedString.lastIndexOf(" ");
    }

    public static int lengthOfLastWord4(String s) {
       int length = 0;

       for(int i = s.length() -1; i>=0; i--){
           if (s.charAt(i) != ' ') {
               length++;
           } else{
               if (length > 0) {
                   return length;
               }
           }
       }
       return length;
    }

    public static String longestCommonPrefix(String[] strs) {
           String prefix = strs[0];
            for (String str : strs) {
                while (!str.startsWith(prefix)) {
                    prefix = prefix.substring(0,prefix.length()-1);
                }
            }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length -1];
        int index = 0;

        while (index < firstStr.length() && index < lastStr.length()){
            if(firstStr.charAt(index) != lastStr.charAt(index)){
                break;
            } else {
                index++;
            }
        }

        String commonPrefix = firstStr.substring(0, index);
        return commonPrefix;
    }
}
