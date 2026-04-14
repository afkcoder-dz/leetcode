package com.java.leetcode.string;

import java.util.*;

public class ZigzagConversion {
    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        int numRows = 4;
//        String s2 = "PAYPALISHIRING";
//        int numRows2 = 3;
        String s3 = "ABCD";
        int numRows3 = 3;
  //      System.out.println(convert2(s, numRows));
  //      System.out.println(convert2(s2, numRows2));
        System.out.println(convert2(s3, numRows3));
    }

    public static String convert1(String s, int numRows) {
        Map<Integer, List<Character>> integerCharacterMap = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (j < numRows && i < s.length()) {
                integerCharacterMap.computeIfAbsent(j, k -> new LinkedList<>());
                integerCharacterMap.get(j).add(s.charAt(i));
                i++;
                j++;
            }
            j--;
            while (j > 1 && i < s.length()) {
                integerCharacterMap.get(--j).add(s.charAt(i));
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        integerCharacterMap.keySet().stream().sorted()
                .forEach(k -> integerCharacterMap.get(k).forEach(stringBuilder::append));
        return stringBuilder.toString();
    }


    public static String convert2(String s, int numRows) {
        StringBuilder stringBuilder = new StringBuilder();
        if(numRows == 1 || s.length() <= 1) {
            return s;
        }

        int n = (s.length() - 1)/(2 * (numRows - 1)) + 1;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= n; j++) {
                int index = j*2* (numRows - 1);
                if(i == 0 && index < s.length() - 1) {
                    stringBuilder.append(s.charAt(index));
                }else {
                    if (index - i >= 0 && i < numRows -1 && index - i < s.length()) {
                        stringBuilder.append(s.charAt(index - i));
                    }
                    if (index + i < s.length()) {
                        stringBuilder.append(s.charAt(index + i));
                    }
                }
            }
        }
        return stringBuilder.toString();
    }


    public String convert3(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public String convert3_1(String s, int numRows) {
        int index = 0;
        StringBuilder[] st = new StringBuilder[numRows];
        for (int i = 0; i < st.length; i++) st[i] = new StringBuilder();
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) st[i].append(s.charAt(index++));
            for (int i = numRows - 2; i > 0 && index < s.length(); i--) st[i].append(s.charAt(index++));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < st.length; i++) result.append(st[i]);
        return result.toString();
    }

    public String convert4(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        int idx = 0;
        int direction = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sbs[idx].append(c);
            if (idx == 0 || idx == numRows - 1) direction = -direction;
            idx += direction;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    }

    public String convert_5(String s, int numRows) {
        if (numRows<=1) return s;
        StringBuilder[] sb= new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) sb[i]=new StringBuilder();
        int idx=0, k=1;
        for (char c: s.toCharArray()){
            sb[idx].append(c);
            if (idx==0) k=1;
            if (idx==numRows-1) k=-1;
            idx+=k;
        }
        return String.join("", sb);
    }

    // I like this
    public String convert_6(String s, int numRows) {
        if (numRows<=1) return s;
        StringBuilder[] sb= new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) sb[i]=new StringBuilder();
        int idx=0, k=1;
        for (char c: s.toCharArray()){
            sb[idx].append(c);
            if (idx==0) k=1;
            if (idx==numRows-1) k=-1;
            idx+=k;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length; i++) result.append(sb[i]);
        return result.toString();
    }
}
