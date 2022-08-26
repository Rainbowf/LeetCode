///**
//  * 题目Id：463
//  * 题目：岛屿的周长
//  * 日期：2022-08-07 15:24:28
//*/
////给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
////
//// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
////
//// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
////的周长。
////
////
////
//// 示例 1：
////
////
////
////
////输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
////输出：16
////解释：它的周长是上面图片中的 16 个黄色的边
////
//// 示例 2：
////
////
////输入：grid = [[1]]
////输出：4
////
////
//// 示例 3：
////
////
////输入：grid = [[1,0]]
////输出：4
////
////
////
////
//// 提示：
////
////
//// row == grid.length
//// col == grid[i].length
//// 1 <= row, col <= 100
//// grid[i][j] 为 0 或 1
////
//// Related Topics深度优先搜索 | 广度优先搜索 | 数组 | 矩阵
////
//// 👍 570, 👎 0
////
////
////
////
//
//package leetcode.editor.cn;
//public class IslandPerimeter {
//    public static void main(String[] args) {
//        Solution solution = new IslandPerimeter().new Solution();
//        System.out.println("Hello world");
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//        private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        private int m, n;
//        public int islandPerimeter(int[][] grid) {
//            m = grid.length; n = grid[0].length;
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (grid[i][j] == 1) {
//                        grid[i][j] = -1;
//                        return dfs(i, j, grid);
//                    }
//                }
//            }
//            return 0;
//        }
//
//        private int dfs(int i, int j, int[][] grid) {
//            int num = 0;
//            for (int[] dir: dirs) {
//                int r = i + dir[0], c = j + dir[1];
//                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
//                    grid[r][c] = -1;
//                    num += dfs(r, c, grid);
//                } else if (r < 0 || r >= m || c < 0 || c >= n) {
//                    num++;
//                } else if (grid[r][c] == 0) {
//                    num++;
//                } else {
//                    continue;
//                }
//            }
//            return num;
//        }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}