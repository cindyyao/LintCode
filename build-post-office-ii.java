/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Java
@Datetime: 17-03-20 03:51
*/

class Coordinates {
    public int x, y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int[][] distanceMap = new int[grid.length][grid[0].length];
        int[][] vote = new int[grid.length][grid[0].length];
        
        int[] deltaX = {1, -1, 0, 0};
        int[] deltaY = {0, 0, 1, -1};
        
        int numHouse = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numHouse++;
                    Queue<Coordinates> queue = new LinkedList<>();
                    queue.offer(new Coordinates(i, j));
                    int distance = 0;
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        distance++;
                        for (int s = 0; s < size; s++) {
                            Coordinates currPoint = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                Coordinates adj = new Coordinates(currPoint.x + deltaX[k], currPoint.y + deltaY[k]);
                                //System.out.println(adj.x + " " + adj.y);
                                if (inBound(adj, grid) && !visited[adj.x][adj.y] && grid[adj.x][adj.y] == 0) {
                                    queue.offer(adj);
                                    visited[adj.x][adj.y] = true;
                                    //System.out.println(distance);
                                    distanceMap[adj.x][adj.y] += distance;
                                    vote[adj.x][adj.y] ++;
                                }
                            }
                        }
                    }
                } 
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (distanceMap[i][j] < min && vote[i][j] == numHouse) {
                    min = distanceMap[i][j];
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    private boolean inBound(Coordinates adj, int[][] grid) {
        return adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length;
    } 
}