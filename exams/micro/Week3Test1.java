package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week3Test1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

//    int[] X = {2, 4, 2, 6, 7, 1};
//    int[] Y = {0, 5, 3, 2, 1, 5};
//    int W = 2;

    int[] X = {4, 8, 2, 2, 1, 4};
    int[] Y = {1, 2, 3, 1, 2, 3};
    int W = 3;
    System.out.println(solution(X,Y,W));
  }
  public static int solution(int[] X, int[] Y, int W) {
    // write your code in Java 8 (Java SE 8)
    TreeSet<Integer> set = new TreeSet<>();
    int res = 0;
    for (int x: X) {
      set.add(x);
    }
    int cur = set.first() - W - 1;
    for (int a : set){
      if (a >= cur + W) {
        cur = a;
        res++;
      }
    }
    return res;
  }
}
