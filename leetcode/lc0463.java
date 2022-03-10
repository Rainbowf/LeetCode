package leetcode;

import java.util.*;

class Solution0463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return getNum(grid, visited, i, j);
                }
            }
        }
        return num;
    }

    //基于 广度优先搜索
    private int getNum(int[][] grid, boolean[][] visited, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //插入头结点
        queue.add(new int[]{i , j});
        visited[i][j] = true;

        //定义方向
        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        int num = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.remove();

            for(int[] dir: dirs){
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }else if(r <0 || r >=m || c <0 || c >= n){
                    num++;
                }else if(grid[r][c] == 0){
                    num++;
                }
            }
        }
        return num;
    }
}