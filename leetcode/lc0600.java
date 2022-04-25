package leetcode;

import java.util.*;
//offer2q090

class Solution0600 {
    //内存超限制，why?
    public static void main(String[] args) {
        char[] chars = {'3', '1'};
        System.out.println(findIntegers(6));
    }

    public static int findIntegers(int n) {
        int[] dp = new int[n + 1];
        int[] res = new int[n + 1];

        dp[0] = 1;
        res[0] = 1;

        dp[1] = 1;
        res[1] = 2;
        for (int i = 2; i <= n; i++) {
            if ((i & 3) == 3) {//10  或者 01 或者 00
                dp[i] = 0;
            } else {
                dp[i] = dp[i >> 1];
            }
            res[i] = res[i - 1] + dp[i];
        }
        return res[n];
    }

    public static int findIntegers2(int n) {
        /*
        dp[i] = dp[i - 1] + dp[i - 2]
        */
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        String numStr = getBinary(n);

        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                continue;
            }
            res += dp[numStr.length() - i - 1];
            if (i != 0 && numStr.charAt(i - 1) == '1') {
                return res;
            }
        }
        return res + 1;
    }

    //get the binary form of number
    //15  -> 1111
    private static String getBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num & 1);
            num >>= 1;
        }
        return sb.toString();
    }
}