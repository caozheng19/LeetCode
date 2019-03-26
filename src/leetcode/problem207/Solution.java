package leetcode.problem207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDgree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            inDgree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDgree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int value = queue.poll();
                list.add(value);
                for (int j = 0; j < graph[value].length; j++) {
                    if (graph[value][j] == 1) {
                        inDgree[j]--;
                    }
                    if (inDgree[j] == 0 && graph[value][j] == 1) {
                        queue.add(j);
                    }
                }
            }
        }
        return list.size() == numCourses ? true : false;
    }
}
