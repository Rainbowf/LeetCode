package leetcode;

import java.util.*;

class Solution0130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    getNum(board, visited, i, j);
                }
            }
        }
    }

    //基于 广度优先搜索
    private void getNum(char[][] board, boolean[][] visited, int i, int j){
        int m = board.length;
        int n = board[0].length;
        //队列
        Queue<int[]> queue = new LinkedList<>();
        //插入头结点
        queue.add(new int[]{i , j});
        visited[i][j] = true;
        board[i][j] = 'X';
        //定义方向
        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int[] pos = queue.remove();

            for(int[] dir: dirs){
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && board[r][c] == 'O'){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    board[r][c] = 'X';
                }else if(r <0 || r >=m || c <0 || c >= n){
                    board[pos[0]][pos[1]] = 'O';
                }
            }
        }
    }
}