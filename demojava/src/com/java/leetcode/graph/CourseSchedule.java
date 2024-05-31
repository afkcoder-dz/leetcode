package com.java.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            degrees[course]++;
            graph.get(prerequisiteCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            resultList.add(course);
            for (int neighbor : graph.get(course)) {
                degrees[neighbor]--;
                if (degrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return resultList.size() >= numCourses;
    }


}
