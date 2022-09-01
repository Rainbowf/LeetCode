package exams.huawei;

import java.util.Scanner;
import java.util.*;

public class Test3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String t = in.nextLine();
    String s = in.nextLine();

    String[] tArr = t.trim().split("\\s+");
    String[] sArr = s.trim().split("\\s+");

    int m = sArr.length;
    int n = tArr.length;

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i < m; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < m; j++) {
      dp[0][j] = 2 * j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (sArr[i - 1].equals(tArr[j - 1])) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int choice1 = dp[i - 1][j] + 1;
          int choice2 = dp[i][j - 1] + 2;

          char[] tChars = tArr[j - 1].toCharArray();
          int[] cntt = new int[26];
          for (char tch: tChars) {
            cntt[tch - 'a']++;
          }

          char[] sChars = sArr[i - 1].toCharArray();
          int tempCnt = 0;
          for (char sch: sChars) {
            if (cntt[sch - 'a'] > 0) {
              tempCnt++;
              cntt[sch - 'a']++;
            }
          }

          int choice3 = -1;
          if (tempCnt * 2 > tChars.length) {
            choice3 = dp[i - 1][j - 1] + 1;
          } else {
            choice3 = dp[i - 1][j - 1] + 3;
          }

          dp[i][j] = Math.min(Math.min(choice1, choice2), choice3);
        }
      }
    }
    int res = tArr.length - dp[m][n];
    System.out.println(res);
  }
}