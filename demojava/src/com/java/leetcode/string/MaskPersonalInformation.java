package com.java.leetcode.string;

public class MaskPersonalInformation {

    public String maskPII(String s) {
        if (s.contains("@")) {
            // EMAIL
            s = s.toLowerCase();
            int at = s.indexOf('@');

            return s.charAt(0) +
                    "*****" +
                    s.charAt(at - 1) +
                    s.substring(at);
        } else {
            // PHONE
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {

                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }

            String digits = sb.toString();
            // String digits = s.replaceAll("\\D", "");
            //\d → any digit (0–9)
            //\D → any non-digit
            int n = digits.length();

            String local = "***-***-" + digits.substring(n - 4);

            if (n == 10)
                return local;

            return "+" + "*".repeat(n - 10) + "-" + local;
        }
    }







}
