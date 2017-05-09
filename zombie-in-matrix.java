/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/zombie-in-matrix
@Language: Java
@Datetime: 17-03-15 03:55
*/

class Coordinates {
    int x,y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int day = 0;
        Queue<Coordinates> newZombie = new LinkedList<Coordinates>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    newZombie.offer(new Coordinates(i, j));
                }
            }
        }
        int[] xCorr = {1, 0, 0, -1};
        int[] yCorr = {0, 1, -1, 0};
        while (newZombie.size() != 0) {
            day++;
            int size = newZombie.size();
            for (int i = 0; i < size; i++) {
                Coordinates currZombie = newZombie.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinates adj = new Coordinates(currZombie.x + xCorr[j], currZombie.y + yCorr[j]);
                    if (inBound(grid, adj) && grid[adj.x][adj.y] == 0) {
                        grid[adj.x][adj.y] = 1;
                        newZombie.offer(adj);
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day - 1;
    }
    private boolean inBound(int[][] grid, Coordinates adj) {
        return adj.x >= 0 && adj.y >= 0 && adj.x < grid.length && adj.y < grid[0].length;
    }
}