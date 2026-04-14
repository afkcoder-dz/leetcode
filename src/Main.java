import com.java.leetcode.Utils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> logs = Arrays.asList("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3");
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] previousSmallerIndex = new int[n];
        int[] nextSmallerIndex = new int[n];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] maxArea = new int[n];
        // find the previous and next smaller value
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[n - 1 - i]) {
                stack2.pop();
            }
            previousSmallerIndex[i] = !stack1.isEmpty() ? stack1.peek() : -1;
            nextSmallerIndex[n - 1 - i] = !stack2.isEmpty() ? stack2.peek() : n;
            stack1.push(i);
            stack2.push(n - 1 - i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            maxArea[i] = previousSmallerIndex[i] == nextSmallerIndex[i]
                    ? heights[i]
                        : heights[i] * (nextSmallerIndex[i] - previousSmallerIndex[i] - 1);
            res = Math.max(res, maxArea[i]);
        }
        return res;
    }
}