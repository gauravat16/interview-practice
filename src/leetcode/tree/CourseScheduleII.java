package leetcode.tree;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        Map<Integer, Integer> dependencyCounts = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            dependencies.put(i, new ArrayList<>());
            dependencyCounts.put(i, 0);
        }

        for (int[] tuple : prerequisites) {
            dependencies.get(tuple[1]).add(tuple[0]);
            dependencyCounts.put(tuple[0], dependencyCounts.getOrDefault(tuple[0], 0) + 1);
        }

        int[] order = new int[numCourses];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dependencyCounts.get(i) == 0) {
                q.offer(i);
                dependencyCounts.remove(i);
            }
        }

        Set<Integer> seenSet = new HashSet<>();


        while (!q.isEmpty()) {
            int course = q.poll();
            if (seenSet.contains(course)) {
                return new int[]{};
            }
            List<Integer> l = dependencies.get(course);
            for (int i : l) {
                dependencyCounts.put(i, dependencyCounts.get(i) - 1);
                if (dependencyCounts.get(i) == 0) {
                    q.offer(i);
                    dependencyCounts.remove(i);
                }
            }
            seenSet.add(course);
            order[idx++] = course;
        }

        return dependencyCounts.isEmpty() ? order : new int[]{};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
