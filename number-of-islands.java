/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-03-14 04:38
*/

class Coordinates {
    int x;
    int y;
    public Coordinates (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }
    
    private void bfs(boolean[][] grid, int x, int y) {
        int[] xCorr = {1, 0, 0, -1};
        int[] yCorr = {0, 1, -1, 0};
        Queue<Coordinates> queue = new LinkedList<>();
        queue.offer(new Coordinates(x,y));
        while (!queue.isEmpty()) {
            Coordinates corr = queue.poll();
            grid[corr.x][corr.y] = false;
            for (int i = 0; i < 4; i++) {
                Coordinates adj = new Coordinates(corr.x + xCorr[i], corr.y + yCorr[i]);
                if (inBound(adj, grid)) {
                    if (grid[adj.x][adj.y]) {
                        queue.offer(adj);
                    }
                }
            }
        }
    }
    
    private boolean inBound(Coordinates corr, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return corr.x >= 0 && corr.x < m && corr.y >= 0 && corr.y < n;
    }
}