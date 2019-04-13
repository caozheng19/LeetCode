package leetcode.problem210;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] res;
    public int flag = 0;
    public int idx = 0;
    public int[] resError= {};
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i<prerequisites.length;i++){

            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]][prerequisites[i][0]]=1;

        }
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize-->0){
                int v = queue.poll();
                res[idx++] = v;
                flag++;
                for(int w = 0;w<numCourses;w++){

                    if(graph[v][w]==1) {System.out.println(inDegree[w]);inDegree[w]--;System.out.println(inDegree[w]);}
                    if(inDegree[w]==0&&graph[v][w]==1){
                        queue.add(w);
                    }
                }
            }
        }
        if(flag!=numCourses) return resError;
        return res;
    }
}