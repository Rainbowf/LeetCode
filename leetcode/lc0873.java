package leetcode;

import java.util.*;

class Solution0873 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,7,11,12,14,18,29};
        System.out.println(lenLongestFibSubseq(nums1));
    }


    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[arr.length][arr.length];
        map.put(arr[0], 0);

        int res = 2;
        for (int i = 1; i < arr.length; i++) {
            map.put(arr[i], i);
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k > -1 && k < j){
                    dp[i][j] = dp[j][k] + 1;
                }else {
                    dp[i][j] = 2;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}