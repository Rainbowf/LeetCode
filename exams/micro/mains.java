package exams.micro;
import java.util.ArrayList;

public class mains {
  public static void main(String[] args) {
    int[] A = new int[] {1, 1, 1, 9, 9, 9, 9, 7, 8};
    int[] B = new int[] {2, 0, 3, 1, 6, 5, 4, 0, 0};
    System.out.println(solution(A, B));
  }
  static int ans;
  public static int solution(int[] A, int[] B) {
    // write your code in Java 8 (Java SE 8)
    int N = A.length;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < N; i++) {
      graph.get(A[i]).add(B[i]);
      graph.get(B[i]).add(A[i]);
    }
    boolean[] vis = new boolean[N+1];
    int[] cars = new int[N+1];
    dfs(0, vis, cars, graph);
    return ans;
  }
  public static int dfs(int root, boolean[] vis, int [] cars, ArrayList<ArrayList<Integer>> map) {
    vis[root] = true;
    cars[root] = 1;
    for(int i: map.get(root)) {
      if (vis[i]) {
        continue;
      }
//      ans = ans + dfs(i, vis, cars, map);
            int temp = dfs(i, vis, cars, map);
            ans += temp;
      cars[root] += cars[i];
    }
    return (int)Math.ceil(cars[root] / 5.0);
  }
}