package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week4Test2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] A = {2, -2, 3, 0, 4, -7};
    System.out.println(solution(A));
  }
  public static int solution(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int res = 0;
    for (int num: A) {
      sum += num;
      int cnt = map.getOrDefault(sum, 0);
      res += cnt;
      if (res > 1000000000) {
        return -1;
      }
      map.put(sum, cnt + 1);
    }
    return res;
  }
}
