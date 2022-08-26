package exams;

import java.util.*;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example:
        Scanner s = new Scanner(System.in);
        // please finish the function body here.
        int N = s.nextInt();
        System.out.println();
    }
}

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
class main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(n + m);
        }
    }
}

class main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int c = in.nextInt();

            float[] f = new float[c];
            for (int i = 0; i < c; i++) {
                f[i] = in.nextFloat();
            }

            float[][] A = new float[c][c];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < c; j++) {
                    A[i][j] = in.nextFloat();
                }
            }

            float[] res = new float[c];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < c; j++) {
                    res[i] += f[j] * A[j][i];
                }
            }
            float max = 0;
            int imax = -1;
            for (int i = 0; i < c; i++) {
                if (res[i] > max) {
                    imax = i;
                    max = res[i];
                }
            }
            System.out.println(imax);
        }
    }
}

class main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int res = calculate(a, b, c);
                System.out.printf("%f", res);
            }
        }
    }

    private static int calculate(int A, int B, int C) {
        float a = 1, b = A, c = B, d = -c;
        float p = c - b * b / 3;
        float q = d + 2 * b * b * b / 27 - b * c / 3;
        return 0;
    }
}

class main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int[] dots = new int[1000000001];

            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                dots[a] = 1;
            }

            for (int i = 0; i < m; i++) {
                int b = in.nextInt();
                dots[b] = -1;
            }
            for (int i = 2; i < 1000000001; i++) {
                dots[i] += dots[i - 1];
            }

            int q = in.nextInt();

            int one = 0;
            int two = 0;
            int three = 0;

            for (int i = 0; i < q; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                int res = dots[r] - dots[l - 1];
                if (res > 0) {
                    one++;
                } else if (res == 0) {
                    two++;
                } else {
                    three++;
                }
            }

            System.out.printf("%d %d %d", dots[0], dots[1], dots[2]);
            System.out.printf("%d %d %d", one, two, three);
        }
    }
}