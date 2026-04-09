package com.java.leetcode.string;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            char c = s.charAt(j);

            if (c == '-') {
                continue;
            }

            if (i == k) {
                stringBuilder.append('-');
                i = 0;
            }

            stringBuilder.append(Character.toUpperCase(c));
            i++;
        }

        return stringBuilder.reverse().toString();
    }
}
