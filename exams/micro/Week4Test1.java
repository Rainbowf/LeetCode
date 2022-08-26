package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week4Test1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//    int N = -5859;
//    int N = -5000;
    int N = -999995;
//    int N = 15958;
    System.out.println(solution(N));
  }
  public static int solution(int N) {
    // write your code in Java 8 (Java SE 8)
    String num = String.valueOf(N);
    int len = num.length();
    int res = -999995;
    for (int i = 0; i < len; i++) {
      if (num.charAt(i) == '5') {
        int temp = Integer.valueOf(num.substring(0, i) + num.substring(i + 1, len));
        res = Math.max(res, temp);
      }
    }
    return res;
  }
}
