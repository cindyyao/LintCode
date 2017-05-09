/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/knight-shortest-path
@Language: Java
@Datetime: 17-03-20 02:51
*/

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        int distance = 0;
        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[source.x][source.y] = true;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point currPoint = queue.poll();
                for (int i = 0; i < 8; i++) {
                    Point adj = new Point(currPoint.x + deltaX[i], currPoint.y + deltaY[i]);
                    if (!inBound(adj, grid) || grid[adj.x][adj.y] || visited[adj.x][adj.y]) {
                        continue;
                    } else if (adj.x == destination.x && adj.y == destination.y) {
                        return distance;
                    } else {
                        visited[adj.x][adj.y] = true;
                        queue.offer(adj);
                    }
                }
            }
        }
        return -1;
    }
    private boolean inBound(Point adj, boolean[][] grid) {
        return adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length;
    }
}