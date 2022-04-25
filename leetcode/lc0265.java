package leetcode;

import java.util.*;

class Solution0265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int minTemp = Integer.MAX_VALUE;
                for (int p = j + 1; p < j + k; p++) {
                    minTemp = Math.min(minTemp, costs[i - 1][p % k]);
                }
                costs[i][j] += minTemp;
            }
        }

        for (int j = 0; j < k; j++) {
            res = Math.min(res, costs[n - 1][j]);
        }
        return res;
    }
}