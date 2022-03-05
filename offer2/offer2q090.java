package offer2;

import java.util.*;

class Solution090 {
    public int rob(int[] nums) {
        //长度为0
        if (nums.length == 0) return 0;
        //长度为1
        if (nums.length == 1) return nums[0];
        //长度>=2
        int res1 = helper(nums, 0, nums.length - 2);
        int res2 = helper(nums, 1, nums.length - 1);

        return Math.max(res1, res2);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];

        dp[0] = nums[start];

        if (start < end) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j % 2] = Math.max(dp[(j - 2) % 2] + nums[i], dp[(j - 1) % 2]);
        }
        return dp[(end - start) % 2];
    }
}