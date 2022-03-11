package leetcode;

import java.util.*;

class Solution0130 {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    getNum(board, visited, i, j);
                }
            }
        }
    }

    //基于 广度优先搜索
    private void getNum(char[][] board, boolean[][] visited, int i, int j) {
        //队列
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        boolean hasBianjie = false;
        //插入头结点
        queue1.add(new int[]{i, j});
        queue2.add(new int[]{i, j});

        visited[i][j] = true;
        board[i][j] = 'X';
        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue1.isEmpty()) {
            int[] pos = queue1.remove();

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && board[r][c] == 'O') {
                    queue1.add(new int[]{r, c});
                    queue2.add(new int[]{r, c});
                    board[r][c] = 'X';
                    visited[r][c] = true;
                } else if (r < 0 || r >= m || c < 0 || c >= n) {
                    hasBianjie = true;
                }
            }
        }

        while (!queue2.isEmpty() && hasBianjie) {
            int[] pos = queue2.remove();
            board[pos[0]][pos[1]] = 'X';
        }
    }

    //官方解答：dfs
    public void solve2(char[][] board) {
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}