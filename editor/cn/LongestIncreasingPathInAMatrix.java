/**
  * 题目Id：329
  * 题目：矩阵中的最长递增路径
  * 日期：2022-08-07 10:32:24
*/
//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 | 记忆化搜索 | 数组 | 动态规划 | 矩阵 
//
// 👍 681, 👎 0 
//
//
//
//

package leetcode.editor.cn;
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

} 