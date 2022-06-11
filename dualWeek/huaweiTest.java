package dualWeek;

import java.util.*;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

class Main {
    public static void main(String[] args) {
        int[] nums = {-1, -3, -4, 0 , 1, 2, 3, 4, 4};
        System.out.println(calculate(nums));
    }

    public static int calculate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num == 2 || num <= 0) {
                sum += 0;
            } else {
                sum += num;
            }
        }
        return sum;
    }


    //双指针
    public int calculate2(int[] nums){

        Arrays.sort(nums);
        int l = nums.length - 1;
        int r = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(; l <= r; r--){

            sum += nums[l];

            while (l >= 0 && sum % 3 == 0){
                max = Math.max(sum, max);
                l--;
            }
            sum -= nums[r];
        }
        return sum;
    }


    //双指针
    public int calculate3(int[] nums){
        int sum = 0;
        for(int num: nums){
            if(num > 0){
                sum += num;

            }

        }

        int re = sum % 3;


        return sum;
    }






}




//
//
//
//    private static int topK(String[] strs, int k) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String str : strs) {
//            if (!map.containsKey(str)) {
//                map.put(str, 1);
//            } else {
//                map.put(str, map.get(str) + 1);
//            }
//        }
//
//        PriorityQueue<HashMap.Entry> minHeap = new PriorityQueue<>((e1, e2) -> calculate(e1, e2));
//
//        for (HashMap.Entry entry : map.entrySet()) {
//            if (minHeap.size() < k) {
//                minHeap.offer(entry);
//            } else {
//                HashMap.Entry peek = minHeap.peek();
//                if (calculate(peek, entry) > 0) {
//                    minHeap.poll();
//                    minHeap.offer(entry);
//                }
//            }
//        }
//        return 0;
//    }
//
//    private static int calculate(HashMap.Entry e1, HashMap.Entry e2) {
//        //比较频率
//        if (e1.getValue() == e2.getValue()) {
//            String s1 = (String) e1.getKey();
//            String s2 = (String) e2.getKey();
//            int i = 0;
//            for (; i < s1.length() && i < s2.length(); i++) {
//                if (s1.charAt(i) < s1.charAt(i)) {
//
//                }
//            }
//            return i == s1.length() ? 1 : -1;//改
//
//        } else {
//            Integer v1 = (Integer) e1.getValue();
//            Integer v2 = (Integer) e2.getValue();
//            return v1 - v2;
//        }
//    }
//
//
//    private static int countNum(char[] chars, int mode) {
//        int q = 1;
//        int res = 0;
//        for (int i = chars.length - 1; i >= 0; i--) {
//
//            int num = change2num(chars[i]);
//            if (num >= mode) return -1;
//            res += num * q;
//            q *= mode;
//        }
//        return res;
//    }
//
//    private static int change2num(char ch) {
//        int res = ch - '0';
//        if (res < 10) {
//            return res;
//        } else return res - 7;
//    }
//}


//
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        int N = s.nextInt();
//        int M = s.nextInt();
//
////        HashMap<String, Integer> shunxv = new HashMap<>();
//        Map<String, int[]> strCount = new HashMap<>();//记录频率
//
//        int k = 0;//存放标题顺序
//        int p = 0;//存放文本顺序
//        int l = 0;//存放总顺序
//
//        Map<Integer, String> suoyin = new HashMap<>();
//        //0:总频率； 1：标题频率；2：文本频率；3：标题出现顺序 4.文本顺序 5.总顺序
//        for (int i = 0; i < M; i++) {
//            //先处理标题
//            String[] biaoti = s.nextLine().split(" ");
//            for (String str : biaoti) {
//                if (!strCount.containsKey(str)) {
//                    strCount.put(str, new int[6]);
//                    strCount.get(str)[0] = 3;
//                    strCount.get(str)[1] = 3;
//                    strCount.get(str)[3] = k++;
//                    suoyin.put(l, str);
//                    strCount.get(str)[5] = l++;
//                } else {
//                    strCount.get(str)[0] += 3;
//                    strCount.get(str)[1] += 3;
//                }
//            }
//            //再处理文本
//            String[] wenben = s.nextLine().split(" ");
//            for (String str : wenben) {
//                if (!strCount.containsKey(str)) {
//                    strCount.put(str, new int[6]);
//                    strCount.get(str)[0] = 1;
//                    strCount.get(str)[2] = 1;
//                    strCount.get(str)[4] = p++;
//                    suoyin.put(l, str);
//                    strCount.get(str)[5] = l++;
//                } else {
//                    strCount.get(str)[0] += 1;
//                    strCount.get(str)[2] += 1;
//                }
//            }
//        }
//        int[][] paixv = new int[strCount.size()][6];
//
//        int m = 0;
//        for (Map.Entry<String, int[]> entry : strCount.entrySet()) {
//            for (int q = 0; q < 6; q++) {
//                paixv[m][q] = entry.getValue()[q];
//            }
//            m++;
//        }
//        // 自定义排序
//        Arrays.sort(paixv, (o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                if (o1[1] == o2[1]) {
//                    if (o1[3] == o2[3]) {
//                        if (o1[4] == o2[4]) {
//                            return o2[2] - o1[2];
//                        } else {
//                            return o1[4] - o2[4];
//                        }
//                    } else {
//                        return o1[3] - o2[3];
//                    }
//                } else {
//                    return o2[1] - o1[1];
//                }
//            } else {
//                return o2[0] - o1[0];
//            }
//        });
//        // please define the JAVA output here. For example:
//        int minNum = Math.min(N, paixv.length);
//        String[] res = new String[minNum];
//        for (int i = 0; i < minNum; i++) {
//            String temp = suoyin.get(paixv[i][5]);
//            System.out.println(temp);
//            System.out.println(paixv[i][0]);
////            res[i] = temp;
//        }
////        System.out.print(String.join(" ", res));
//    }
////
////    public static void main2(String[] args) {
////        // please define the JAVA input here. For example:
////        Scanner s = new Scanner(System.in);
////        // please finish the function body here.
////        String str = s.nextLine().toLowerCase();
////        StringBuffer newStr = new StringBuffer(str.length());
////        for (char ch : str.toCharArray()) {
////            if (ch == 'a') {
////                newStr.append('A');
////            } else if (ch == 'e') {
////                newStr.append('E');
////            } else if (ch == 'i') {
////                newStr.append('I');
////            } else if (ch == 'o') {
////                newStr.append('O');
////            } else if (ch == 'u') {
////                newStr.append('U');
////            } else {
////                newStr.append(ch);
////            }
////        }
////        // please define the JAVA output here. For example:
////        System.out.println(new String(newStr));
////    }
////
////    public static void main3(String[] args) {
////        // please define the JAVA input here. For example:
////        Scanner s = new Scanner(System.in);
////        // please finish the function body here.
////        String str = s.nextLine();
////
////        int[] dp = new int[11];
////        dp[0] = 1;
////        for (int i = 1; i <= 10; i++) {
////            dp[i] = dp[i - 1] * i;
////        }
////        int res = dp[str.length()];
////
////        int[] cnt = new int[26];
////        for (char ch : str.toCharArray()) {
////            cnt[ch - 'A']++;
////        }
////        for (int i = 0; i < 26; i++) {
////            res /= dp[cnt[i]];
////        }
////
////        // please define the JAVA output here. For example:
////        System.out.println(res);
////    }
////
////    public static void main4(String[] args) {
////        // please define the JAVA input here. For example:
////        Scanner s = new Scanner(System.in);
////        // please finish the function body here.
////        int n = s.nextInt();//台阶长度
////        int[] taijie = new int[n];
////        for (int i = 0; i < n; i++) {
////            taijie[i] = s.nextInt();
////        }
////        int k = s.nextInt();
////
////        int[] dp = new int[n];
////        Arrays.fill(dp, k + 1);
////        dp[0] = 0;
////        for (int i = 1; i <= n; i++) {
////            for (int j = 0; j < i; j++) {
////                if (taijie[j] >= i - j) {
////                    dp[i] = Math.min(dp[j] + 1, dp[i]);
////                }
////            }
////        }
////        if (dp[n - 1] <= k) {
////            System.out.println(dp[n-1]);
////        } else {
////            System.out.println('A'-'0');
////        }
////        // please define the JAVA output here. For example:
////    }
//
//        System.out.println(
//
//    change2num('0'));
//}
//
//    public static void main5(String[] args) {
//        // please define the JAVA input here. For example:
//        Scanner s = new Scanner(System.in);
//
//        // please finish the function body here.
//        String str = s.nextLine();//匹配串
//        int n = s.nextInt();
//        int[] flags = new int[n];
//        for (int i = 0; i < n; i++) {
//            flags[i] = s.nextInt();
//        }
//
//        int i = 0;
//        for (int j = 0; j < n; j++) {
//            for (; i < str.length() - 3; i += 2) {
//                int sum1 = change2num(str.charAt(i)) + change2num(str.charAt(i + 1));
//                if (sum1 == flags[j]) {
//                    int sum2 = change2num(str.charAt(i + 2)) + change2num(str.charAt(i + 3));
//                    if ((str.length() - (i + 4)) / 2 > sum2) {
//                        System.out.println(sum2 + " " + (i + 4) / 2);
//                    }
//                }
//            }
//            if (i >= str.length() - 3) {
//                System.out.println(0 + " " + 0);
//                i = 0;
//
//            }
//        }
//        // please define the JAVA output here. For example:
//    }
//
//    private static int change2num(char ch) {
//        if (ch - '0' < 10) return ch - '0';
//        else return ch - '0' - 7;
//    }
//}
//

//
//点击率预估
//论文
//问题：
//项亮（深度学习之前，典型算法）