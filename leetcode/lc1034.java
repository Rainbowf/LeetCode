package leetcode;

import java.util.*;

class Solution1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int co = grid[row][col];//2
        //队列
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        //插入头结点
        queue1.add(new int[]{row, col});
        visited[row][col] = true;

        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue1.isEmpty()) {
            int[] pos = queue1.remove();

            boolean isBianjie = false;
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                //找同色
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == co && !visited[r][c]) {
                    queue1.add(new int[]{r, c});
                    visited[r][c] = true;
                }

                if(r < 0 || r >= m || c < 0 || c >= n || (grid[r][c] != co &&  grid[r][c] !=-1)){
                    isBianjie = true;
                }
            }
            if(isBianjie){
                grid[pos[0]][pos[1]] = -1;
                queue2.add(pos);
            }
        }
        while(!queue2.isEmpty()){
            int[] pos = queue2.remove();
            grid[pos[0]][pos[1]] = color;

        }
        return grid;
    }
}