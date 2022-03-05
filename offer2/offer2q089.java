package offer2;

import java.util.*;

class Solution089 {
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[2];

        dp[0] = nums[0];

        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i], dp[(i - 1) % 2]);
        }
        return dp[(nums.length - 1) % 2];
    }

    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;

        int[][] dp = new int[2][2];

        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[0][i % 2] =   Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = nums[i] + dp[0][(i - 1) % 2];
        }
        return Math.max(dp[0][(nums.length - 1) % 2], dp[1][(nums.length - 1) % 2]);
    }
}