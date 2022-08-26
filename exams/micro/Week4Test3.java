package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week4Test3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
//    int[] A = new int[10000];
//    Arrays.fill(A, -2000000000);
    System.out.println(solution(A));
  }
  public static int solution(int[] A) {
    // write your code in Java 8 (Java SE 8)
    int n = A.length;
    int l = 0;
    long res = 0;
    while (l < n - 2) {
      int r = l + 1;
      if ((long)A[l + 2] - A[l + 1] == (long)A[l + 1] - A[l]) {
        r = l + 2;
        while (r < n && (long)A[r] - A[r - 1] == (long)A[r - 1] - A[r - 2]) {
          r++;
        }
        int len = r - l;
        res = res + (long)(len - 1) * (len - 2) / 2;
        if (res > 1000000000) {
          return -1;
        }
        r--;
      }
      l = r;
    }
    return (int)res;
  }
}
