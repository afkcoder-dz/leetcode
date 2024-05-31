package com.java.leetcode.bitmanipulation;

public class ReverseBits {

        public int reverseBits(int n) {
            int result = 0;

            for (int i = 0; i < 32; i++) {
                // Extract the least significant bit
                int bit = n & 1;

                // Shift result to the left and add the extracted bit
                result = (result << 1) | bit;

                // Shift n to the right to process the next bit
                n >>= 1;
            }

            return result;
        }

        public static void main(String[] args) {
            ReverseBits rb = new ReverseBits();
            int n = 43261596; // Example input
            System.out.println(rb.reverseBits(n)); // Output: 964176192
        }

}
