package leetcode;

import java.util.*;

class Solution0329 {
    private int m, n;
    private int[][] len;
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int maxLen = 1;
        len = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j) {
        //自己算作一个
        int length = 1;
        if (len[i][j] != 0) {
            return len[i][j];
        }
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[i][j]) {
                int temp = dfs(matrix, r, c);
                length = Math.max(temp + 1, length);
            }
        }
        len[i][j] = length;
        return length;
    }
}