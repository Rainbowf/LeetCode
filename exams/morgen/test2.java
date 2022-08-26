package exams.morgen;
//package exams.micro;

import java.util.Scanner;
import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 11;
        System.out.println(compare("1011", "1101"));
    }

    private static int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static int solution(long x) {
        List<Integer> grey = new ArrayList<Integer>();
        while (x > 0) {
            grey.add((int)(x & 1));
            x = x >> 1;
        }
        int n = grey.size();
        int res = grey.get(n-1);
        for (int i = n - 2; i >= 0; i--) {
            grey.set(i, grey.get(i + 1) ^ grey.get(i));
            res = (res << 1) + grey.get(i);
        }
        return res;
    }


}
