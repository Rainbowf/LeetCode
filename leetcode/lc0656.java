package leetcode;

import java.util.*;
//动态规划

class Solution0656 {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        List<Integer> res = new ArrayList<>();

        int[] dp = new int[coins.length];
        int[] next = new int[coins.length];
        Arrays.fill(next, -1);

        for (int i = coins.length - 2; i >= 0; i--) {
            int min_cost = Integer.MAX_VALUE;

            for (int j = i + 1; j < coins.length && j <= i + maxJump; j++) {
                if (coins[j] >= 0) {
                    int cost = coins[i] + dp[j];
                    if (cost < min_cost) { //由于j是从小到大遍历，所以是按照字典序的
                        min_cost = cost;
                        next[i] = j;
                    }
                }
                //如果j均不可达，则next[i]=-1；
            }

            dp[i] = min_cost;
        }

        //返回结果
        int i;
        for (i = 0; i < coins.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        if (i == coins.length - 1 && coins[i] >= 0) {
            res.add(coins.length);
        } else {
            return new ArrayList<>();
        }
        return res;
    }
}