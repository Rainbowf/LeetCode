package exams.huawei;

import java.util.Scanner;
import java.util.*;

class Test2 {
  private static double res;
  private static boolean[] visited;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] dsts = new int[6][2];
    for (int i = 1; i < 6; i++) {
      dsts[i][0] = in.nextInt();
      dsts[i][1] = in.nextInt();
    }
    double[][] weights = new double[5][5];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != j) {
          int dx = dsts[i][0] - dsts[j][0];
          int dy = dsts[i][1] - dsts[j][1];
          weights[i][j] = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
        }
      }
    }
    visited = new boolean[6];
    visited[0] = true;
    res = Integer.MAX_VALUE;

    helper(dsts, 0, 0,weights);
    System.out.println((int)res);
  }

  private static void helper(int[][] dsts, int index, double sum, double[][] weights) {
    if (visited[1] && visited[2] && visited[3] && visited[4] && visited[5]) {
      sum += weights[index][0];
      res = Math.min(sum, res);
      return;
    }
    for (int i = 1; i <= 5; i++) {
      if (i != index && !visited[i]) {
        double dis = weights[index][i];
        sum += dis;
        visited[i] = true;
        helper(dsts, i, sum,weights);
        sum -= dis;
        visited[i] = false;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    if (i != j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}