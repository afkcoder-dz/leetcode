package com.java.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords5(" asdasd     df f"));
    }


    public static String reverseWords_mySolution(String s) {
        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        int pre = -1;
        int post = -1;

        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i] != ' ' && post == -1) {
                post = i;
            }
            if (i == 0 && chars[i] != ' ') {
                pre = 0;
            } else {
                if (chars[i] == ' ' && post != -1) {
                    pre = i + 1;
                }
            }
            if (pre <= post && pre >= 0) {
                for (int j = pre; j <= post; j++) {
                    str.append(chars[j]);
                }
                str.append(" ");
                pre = -1;
                post = -1;
            }
        }
        return str.toString().trim();
    }

    // This method share the same solution with my method, but it is more clear and precise.
    public static String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1; // the post pointer of a word
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1; // the pre pointer of a word
            while (j >= 0 && (s.charAt(j) != ' ')) {
                j--;
            }
            sb.append(" ");
            sb.append(s, j + 1, i + 1);
            i = j - 1;
        }
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }

    /**
     * method 3 ~ method 5 share the same solution
     **/
    public static String reverseWords3(String s) {
        String[] ss = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            {
                result.append(ss[i]).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String reverseWords4(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public static String reverseWords5(String s) {
        Stack<String> st = new Stack<String>();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                st.push(a);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }


}
