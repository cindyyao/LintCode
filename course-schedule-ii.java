/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/course-schedule-ii
@Language: Java
@Datetime: 17-03-19 21:36
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        ArrayList[] edges = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index] = course;
            index++;
            for (int i = 0; i < edges[course].size(); i++) {
                int totake = (int)edges[course].get(i);
                inDegree[totake]--;
                if (inDegree[totake] == 0) {
                    queue.offer(totake);
                }
            }
        }
        if (index < numCourses) {
            return new int[0];
        }
        return order;
    }
}