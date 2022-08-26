package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week3Test3 {
  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int[] A = {0, 1, 1};
//    int[] B = {1, 2, 3};

    int[] A = {1, 1, 1, 9, 9, 9, 9, 7, 8};
    int[] B = {2, 0, 3, 1, 6, 5, 4, 0, 0};

    System.out.println(solution(A,B));
  }

  private static int res;
  private static boolean[] visited;

  public static int solution(int[] A, int[] B){
    if (A.length != B.length) {
      return -1;
    }
    int n = A.length;
    List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      graph[A[i]].add(B[i]);
      graph[B[i]].add(A[i]);
    }
    res = 0;
    visited = new boolean[n + 1];
    visited[0] = true;

    for (int start : graph[0]) {
      dfs(graph, start);
    }
    return res;
  }

  public static int dfs(List<Integer>[] graph, int root){
    boolean flag = true;
    for (int next : graph[root]) {
      flag &= visited[next];
    }
    if (flag) {
      res++;
      return 1;
    }
    visited[root] = true;
    int sum = 1;
    for (int next : graph[root]) {
      if (visited[next]){
        continue;
      }
      int tmp = dfs(graph, next);
      sum += tmp;
    }
    res += 1 + sum / 5;
    return sum;
  }
}
