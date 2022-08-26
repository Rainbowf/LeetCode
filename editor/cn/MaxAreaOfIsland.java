/**
  * 题目Id：695
  * 题目：岛屿的最大面积
  * 日期：2022-08-07 11:00:16
*/
//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 823, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //定义方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;

            for(int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        res = Math.max(res, dfsStack(i, j, grid));
                    }
                }
            }
            
            return res;
        }

        private int dfs(int i, int j, int[][] grid) {
            int len = 1;
            grid[i][j] = -1;
            for(int[] dir: dirs) {
                int r = i + dir[0], c = j + dir[1];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                    len += dfs(r,c,grid);
                }
            }
            return len;
        }

        private int bfs(int i, int j, int[][] grid) {
            int len = 0;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j});
            grid[i][j] = -1;

            while (!queue.isEmpty()) {
                int[] pos = queue.remove();
                len++;

                for(int[] dir: dirs) {
                    int r = pos[0] + dir[0], c = pos[1] + dir[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        queue.add(new int[]{r, c});
                        grid[r][c] = -1;
                    }
                }
            }

            return len;
        }

        private int dfsStack(int i, int j, int[][] grid) {
            int len = 0;

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{i, j});
            grid[i][j] = -1;

            while (!stack.isEmpty()) {
                int[] pos = stack.pop();
                len++;

                for (int[] dir: dirs) {
                    int r = pos[0] + dir[0], c = pos[1] + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        stack.push(new int[]{r, c});
                        grid[r][c] = -1;
                    }
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 