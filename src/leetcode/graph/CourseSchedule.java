package leetcode.graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] dependents = new LinkedList[numCourses];
        int[] dependingOnArr = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            dependents[i] = new LinkedList<>();
        }

        for (int[] p : prerequisites) {
            dependents[p[1]].add(p[0]);
            dependingOnArr[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dependingOnArr[i] == 0) {
                q.offer(i);
            }
        }

        int finished = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            finished++;
            for (int c : dependents[course]) {
                dependingOnArr[c]--;
                if (dependingOnArr[c] == 0) {
                    q.offer(c);
                }
            }

        }

        return finished == numCourses;


    }

}
