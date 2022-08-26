/**
  * 题目Id：130
  * 题目：被围绕的区域
  * 日期：2022-08-07 16:58:18
*/
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 839, 👎 0 
//
//
//
//

package leetcode.editor.cn;

public class SurroundedRegions
{
    public static void main(String[] args)
    {
        Solution solution = new SurroundedRegions().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution
    {
        int m, n;
        
        public void solve(char[][] board)
        {
            m = board.length;
            n = board[0].length;
            // 边界相连的O全部设置为A
            for (int i = 0; i < m; i++)
            {
                dfs(board, i, 0);
                dfs(board, i, n - 1);
            }
            
            for (int j = 0; j < n; j++)
            {
                dfs(board, 0, j);
                dfs(board, m - 1, j);
            }
            // 边界上的A还原为O, 内部的O变为X
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (board[i][j] == 'A')
                    {
                        board[i][j] = 'O';
                    }
                    else if (board[i][j] == 'O')
                    {
                        board[i][j] = 'X';
                    }
                }
            }
            return;
        }
        
        /**
        * @description: 把边界内的O相连部分全部变为A
        * @param [board, i, j]
        * @return void
        * @throws 
        * @author Ryan
        * @date 2022/08/07 17:26
        */
        private void dfs(char[][] board, int i, int j)
        {
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            {
                return;
            }
            board[i][j] = 'A';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    
}