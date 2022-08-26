package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week3Test2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = "39878";
//    String s = "00900";
//    String s = "0000";
//    String s = "54321";
    System.out.println(solution(s));
  }
  public static String solution(String s) {
    // write your code in Java 8 (Java SE 8)
    int[] cnts = new int[10];
    for (char ch: s.toCharArray()) {
      cnts[ch - '0']++;
    }
    int mid = -1;
    int n = 0;
    for (int i = 9; i >= 0; i--) {
      if (cnts[i] % 2 == 1 && mid == -1) {
          mid = i;
      }
      cnts[i] /= 2;
      n += cnts[i];
    }
    StringBuilder sb = new StringBuilder();
    int j = 9;
    while (n > 0 && j > 0) {
      while (cnts[j] > 0){
        if (sb.length() != 0 || j != 0){
          sb.append(j);
        }
        cnts[j]--;
      }
      j--;
    }
    String res = sb.toString() + (mid == -1? "" : mid) + sb.reverse().toString();
    return res.length() == 0 ? "0" : res;
  }
}
