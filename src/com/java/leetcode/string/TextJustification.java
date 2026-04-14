package com.java.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words1= new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2 = new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] words3 = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> result = fullJustify(words3, 20);
        result.forEach(System.out::println);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int length = 0;
        int indexOfLastWordOfLastRow = -1;
        for (int i = 0; i < words.length; i++) {
            if (length + words[i].length() <= maxWidth) {
                length = length + words[i].length() + 1;

                if (i == words.length - 1) {
                    // construct last line, left justified
                    int spaces = maxWidth + 1 - length;
                    StringBuilder lineBuilder = new StringBuilder();
                    for (int j = indexOfLastWordOfLastRow + 1; j < words.length - 1; j++) {
                        lineBuilder.append(words[j]).append(" ");
                    }
                    lineBuilder.append(words[i]);
                    lineBuilder.append(" ".repeat(spaces));
                    result.add(lineBuilder.toString());
                }

            } else {
                // construct the line
                int spaces = maxWidth + 1 - length;

                if (i - 1 - indexOfLastWordOfLastRow == 1) {
                    // Only one world in this line
                    // Should be left justified
                    String line = words[i - 1] + " ".repeat(spaces);
                    result.add(line);
                } else { // fully justified
                    int n = indexOfLastWordOfLastRow == -1 ? spaces / (i - 1) : spaces / (i - indexOfLastWordOfLastRow - 1 -1);
                    int m = indexOfLastWordOfLastRow == -1 ? spaces % (i - 1) : spaces % (i - indexOfLastWordOfLastRow - 1 -1);
                    StringBuilder lineBuilder = new StringBuilder();
                    for (int j = indexOfLastWordOfLastRow + 1; j < i; j++) {
                        lineBuilder.append(words[j]);
                        if (j < i - 1) {
                            lineBuilder.append(" ".repeat(n + 1));
                        }
                        if (j < indexOfLastWordOfLastRow + 1 + m) {
                            lineBuilder.append(" ");
                        }
                    }
                    result.add(lineBuilder.toString());
                }
                length = 0;
                indexOfLastWordOfLastRow = i - 1;
                i--;
            }

        }
        return result;
    }


}
