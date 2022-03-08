package leetcode;
import java.util.*;

class Solution0509 {
    //一维数组dp
    public int fib(int n) {
        int[] dp = new int[n+1];

        if(n < 2){
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}