package exams.micro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Ryan
 * @create: 2022-08-14 12:27
 **/

public class Week2Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x = {1, 1, 2};
        int[] y = {3, 2, 3};

//        int[] x = {1, 1, 1};
//        int[] y = {2, 2, 2};

//        int x = 2;
//        int y = 2;
//        int[] z = {4, 2, 3, 7};

        System.out.println(solution(x, y));
    }

    public static int solution(int[] X, int[] Y) {
        // write your code in Java 8 (Java SE 8)
        int N = X.length;
        Map<String, Integer> map = new HashMap<>();

        int res = 0;

        for (int i = 0; i < N; i++) {
            int top = X[i];
            int bottom = Y[i];
            if (top > bottom) {
                continue;
            }
            int anotherTop = bottom - top;
            int base = gcd(anotherTop, bottom);

            bottom /= base;
            top /= base;
            anotherTop /= base;

            String anoTopStr = anotherTop + "/" + bottom;
            String topStr = top + "/" + bottom;

            res += map.getOrDefault(anoTopStr, 0);
            map.put(topStr, map.getOrDefault(topStr, 0) + 1);
        }
        return res % 1000000007;
    }

    private static int gcd(int top, int bottom) {
        return bottom == 0 ? top : gcd(bottom, top % bottom);
    }
}
