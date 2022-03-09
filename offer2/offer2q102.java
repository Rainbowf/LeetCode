package offer2;

class Solution102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        return subsetSum(nums, (sum - target) / 2);


    }

    private int subsetSum1(int[] nums, int target) {
        int l = nums.length;
        int[][] dp = new int[l + 1][target + 1];
//
//        for (int i = 0; i <= l; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= l; i++) {
//            for (int j = 1; j <= target; j++) {
//                if (j >= nums[i - 1]) {
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
//                }else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }

        dp[0][0] = 1;
        for (int i = 1; i <= l; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[l][target];
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = target + 1;
            for (int coin : nums) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }
}

