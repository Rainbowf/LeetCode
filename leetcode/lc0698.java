package leetcode;

import java.util.*;

class Solution0698 {
    //没做出来
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (subsetSum(nums, sum / k)) {
                count++;
            }
        }
        return count == k;
    }

    private boolean subsetSum(int[] nums, int target) {
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];

        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];//不选择
                if (!dp[i][j] && j >= nums[i - 1] && nums[i - 1] != 0) {//选择
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                    nums[i - 1] = 0;
                }
            }
        }
        return dp[len][target];
    }
}