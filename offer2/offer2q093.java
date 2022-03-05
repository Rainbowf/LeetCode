package offer2;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Solution093 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        //把数字对应下标存进哈希表里面
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int result = 2;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                //找到前一个数
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                //k存在且<j,不符合条件的都为2
                dp[i][j] = k >= 0 & k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }
}