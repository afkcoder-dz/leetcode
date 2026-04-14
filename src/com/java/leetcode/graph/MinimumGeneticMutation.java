package com.java.leetcode.graph;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || endGene == null || bank == null) return -1;
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) return -1;

        char[] possibleChars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            mutations++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                char[] currentGeneChars = currentGene.toCharArray();
                for (int j = 0; j < currentGeneChars.length; j++) {
                    char originChar = currentGeneChars[j];
                    for (char c : possibleChars) {
                        if (c != currentGeneChars[j]) {
                            currentGeneChars[j] = c;
                            String mutationGene = new String(currentGeneChars);
                            if (geneBank.contains(mutationGene)) {
                                if (mutationGene.equals(endGene)) return mutations;
                                queue.offer(mutationGene);
                                geneBank.remove(mutationGene);
                            }
                            currentGeneChars[j] = originChar;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int minMutation2(String startGene, String endGene, String[] bank) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        Set<String> vis = new HashSet<>();
        vis.add(startGene);
        int depth = 0;
        while (!q.isEmpty()) {
            for (int m = q.size(); m > 0; --m) {
                String gene = q.poll();
                if (gene.equals(endGene)) {
                    return depth;
                }
                for (String next : bank) {
                    int c = 2;
                    for (int k = 0; k < 8 && c > 0; ++k) {
                        if (gene.charAt(k) != next.charAt(k)) {
                            --c;
                        }
                    }
                    if (c > 0 && !vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
            ++depth;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation test = new MinimumGeneticMutation();
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};

        System.out.println(test.minMutation(startGene, endGene, bank));
        String startGene1 = "AACCGGTT";
        String endGene1 = "AACCGCTA";
        String[] bank1 = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(test.minMutation(startGene1, endGene1, bank1));

        String startGene2 = "AACCTTGG";
        String endGene2 = "AATTCCGG";
        String[] bank2 = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        System.out.println(test.minMutation2(startGene2, endGene2, bank2));
    }
}
