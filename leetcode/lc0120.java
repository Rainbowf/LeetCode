package leetcode;

import java.util.List;
//offer2q100
class Solution0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
                //不是第一行的最左边一列
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                    //不是第一行的对角线
                } else if (i > 0 && j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                    //不是第一行的中间部分
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            min = Math.min(num, min);
        }
        return min;
    }
}