package com.java.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NumberofStudentsUnabletoEatLunch {

    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 1, 0, 0, 1};
        int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int n = students.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            stack.push(sandwiches[n - 1 - i]);
            queue.offer(students[i]);
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            while (stack.peek() != queue.peek()) {
                if (count == n) {
                    res = stack.size();
                    return res;
                }
                int s = queue.poll();
                queue.offer(s);
                count++;
            }
            stack.pop();
            queue.poll();
        }
        return 0;
    }
}
