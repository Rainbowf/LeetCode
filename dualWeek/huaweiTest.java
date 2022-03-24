package dualWeek;

import java.util.*;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

class Main {
    public static void main(String[] args) {
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        String[] strs = s.nextLine().split(" ");
//        double res = 0;
//        if (strs.length == 0) {
//            System.out.printf("%.2f", res);
//        }
//        double sum = 0;
//        for (String str : strs) {
//            sum += str.length();
//        }
//        res = sum / strs.length;
//        // please define the JAVA output here. For example:
//        System.out.printf("%.2f", res);
//    }
//
//    public static void main2(String[] args) {
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        String str = s.nextLine().toLowerCase();
//        StringBuffer newStr = new StringBuffer(str.length());
//        for (char ch : str.toCharArray()) {
//            if (ch == 'a') {
//                newStr.append('A');
//            } else if (ch == 'e') {
//                newStr.append('E');
//            } else if (ch == 'i') {
//                newStr.append('I');
//            } else if (ch == 'o') {
//                newStr.append('O');
//            } else if (ch == 'u') {
//                newStr.append('U');
//            } else {
//                newStr.append(ch);
//            }
//        }
//        // please define the JAVA output here. For example:
//        System.out.println(new String(newStr));
//    }
//
//    public static void main3(String[] args) {
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        String str = s.nextLine();
//
//        int[] dp = new int[11];
//        dp[0] = 1;
//        for (int i = 1; i <= 10; i++) {
//            dp[i] = dp[i - 1] * i;
//        }
//        int res = dp[str.length()];
//
//        int[] cnt = new int[26];
//        for (char ch : str.toCharArray()) {
//            cnt[ch - 'A']++;
//        }
//        for (int i = 0; i < 26; i++) {
//            res /= dp[cnt[i]];
//        }
//
//        // please define the JAVA output here. For example:
//        System.out.println(res);
//    }
//
//    public static void main4(String[] args) {
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        int n = s.nextInt();//台阶长度
//        int[] taijie = new int[n];
//        for (int i = 0; i < n; i++) {
//            taijie[i] = s.nextInt();
//        }
//        int k = s.nextInt();
//
//        int[] dp = new int[n];
//        Arrays.fill(dp, k + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (taijie[j] >= i - j) {
//                    dp[i] = Math.min(dp[j] + 1, dp[i]);
//                }
//            }
//        }
//        if (dp[n - 1] <= k) {
//            System.out.println(dp[n-1]);
//        } else {
//            System.out.println('A'-'0');
//        }
//        // please define the JAVA output here. For example:
//    }

        System.out.println(change2num('0'));
    }

    public static void main5(String[] args) {
        // please define the JAVA input here. For example:
        Scanner s = new Scanner(System.in);

        // please finish the function body here.
        String str = s.nextLine();//匹配串
        int n = s.nextInt();
        int[] flags = new int[n];
        for (int i = 0; i < n; i++) {
            flags[i] = s.nextInt();
        }

        int i = 0;
        for (int j = 0; j < n; j++) {
            for (; i < str.length() - 3; i += 2) {
                int sum1 = change2num(str.charAt(i)) + change2num(str.charAt(i + 1));
                if (sum1 == flags[j]) {
                    int sum2 = change2num(str.charAt(i + 2)) + change2num(str.charAt(i + 3));
                    if((str.length() - (i + 4))/2 > sum2){
                        System.out.println(sum2 + " " + (i + 4) / 2);
                    }
                }
            }
            if (i >= str.length() - 3) {
                System.out.println(0 + " " + 0);
                i = 0;

            }
        }
        // please define the JAVA output here. For example:
    }

    private static int change2num(char ch) {
        if (ch - '0' < 10) return ch - '0';
        else return ch - '0' - 7;
    }
}

