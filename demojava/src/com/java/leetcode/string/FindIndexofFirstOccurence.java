package com.java.leetcode.string;

public class FindIndexofFirstOccurence {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr2(haystack, needle));
    }


    public static int strStr1(String haystack, String needle) {
        int i = 0;
        int len = needle.length();
        while (haystack.length() - i >= len) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (startWith(i, haystack, needle)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }


    public static boolean startWith(int index, String str1, String str2) {
        for (int j = str2.length() - 1; j >= 0; j--) {
            if (str1.charAt(index + j) != str2.charAt(j)) {
                return false;
            }
        }
        return true;

    }


    public static int strStr2(String haystack, String needle) {
        int i = 0;
        int len = needle.length();
        while (haystack.length() - i >= len) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < len; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                    if (j == len - 1)
                        return i;
                }
            }
            i++;
        }
        return -1;
    }

    // this is the best
    public static int strStr3(String haystack, String needle) {
        int n = needle.length();
        for (int i = 0; i <= haystack.length() - n; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + n - 1) == needle.charAt(n - 1)) // check the first and end char to reduce loop time
            {
                for (int j = 0; j < n && haystack.charAt(i + j) == needle.charAt(j); j++) { // this loop condition is important
                    if (j == n - 1) // how to ensure that every element in a loop meets the requirement
                        return i;
                }
            }
        }
        return -1;
    }

    // not time saving because of calling of String.substring() and String.startsWith()
    public int strStr_firstImp(String haystack, String needle) {
        int i = 0;
        while (haystack.length() - i >= needle.length()) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i).startsWith(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int strStr_others(String haystack, String needle) {
        for(int i = 0; ; i++) {
            for(int j = 0; ; j++) {
                if(j == needle.length()) return  i;
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i)) break;
            }
        }
    }
}