package com.java.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

        // use heap
        public List<List<Integer>> kSmallestPairs ( int[] nums1, int[] nums2, int k){
            List<List<Integer>> result = new ArrayList<>();
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
                return result;
            }

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
            );

            // Push the first k pairs from nums1 and nums2[0] into the heap
            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                minHeap.offer(new int[]{i, 0}); // Pair of indices (i, 0)
            }

            // Extract k smallest pairs
            while (k > 0 && !minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int i = current[0];
                int j = current[1];

                // Add the pair to the result
                result.add(Arrays.asList(nums1[i], nums2[j]));

                // Add the next pair from the current row if possible
                if (j + 1 < nums2.length) {
                    minHeap.offer(new int[]{i, j + 1});
                }

                k--;
            }

            return result;
        }

        public static void main (String[]args){
            FindKPairsWithSmallestSums solution = new FindKPairsWithSmallestSums();
            int[] nums1 = {1, 7, 11};
            int[] nums2 = {2, 4, 6};
            int k = 3;

            List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
            System.out.println(result); // Expected output: [[1, 2], [1, 4], [1, 6]]
        }


    /**
     * Complexity Analysis
     * Time Complexity:
     * Heap operations (offer and poll) take O(logk).
     * At most, k pairs are extracted, leading to O(klogk).
     * Overall complexity: O(klogk).
     *
     *
     * Space Complexity:
     * The heap stores at most k elements, requiring O(k) space.
     * Result list takes O(k) space.
     * Total: O(k).
     */
}
