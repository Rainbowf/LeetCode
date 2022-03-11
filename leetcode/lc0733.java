package leetcode;

import java.util.*;

class Solution0733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int co = image[sr][sc];//2
        //队列
        Queue<int[]> queue1 = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        //插入头结点
        queue1.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue1.isEmpty()) {
            int[] pos = queue1.remove();
            image[pos[0]][pos[1]] = newColor;
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                //找同色
                if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == co && !visited[r][c]) {
                    queue1.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return image;
    }
}