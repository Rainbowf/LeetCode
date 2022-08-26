package exams.micro;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Ryan
 * @create: 2022-08-14 12:32
 **/

public class Week2Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 2;
        int y = 2;
        int[] z = {4, 2, 3, 7};

        System.out.println(solution(z, x, y));
    }

    public static int solution(int[] A, int X, int Y) {
        // write your code in Java 8 (Java SE 8)
        int N = A.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i + (X-1) * Y < N; i++) {
            int cur = 0;
            for (int j = 0; j < X; j++) {
                cur += A[i + j * Y];
            }
            res = Math.min(res, cur);
        }
        return res;
    }

    // 同时考虑交易次数的限制、冷冻期和手续费
    static int maxProfit_all_in_one(int max_k, int[] prices, int cooldown) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }

        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MAX_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // base case 1
                    dp[i][k][0] = Integer.MAX_VALUE;
                    dp[i][k][1] = prices[i];
                    continue;
                }

                // 包含 cooldown 的 base case
                if (i - cooldown - 1 < 0) {
                    // base case 2
                    dp[i][k][0] = Math.min(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    // 别忘了减 fee
                    dp[i][k][1] = dp[i-1][k][1];
                    continue;
                }
                dp[i][k][0] = Math.min(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // 同时考虑 cooldown 和 fee

                dp[i][k][1] = Math.min(dp[i-1][k][1], dp[i-cooldown-1][k-1][0]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
