package dualWeek;

import java.util.*;

class Tricks {
    // 全局变量，记录递归函数的递归层数
    int count = 0;

    // 输入 n，打印 n 个 tab 缩进
    void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("   ");
        }
    }

    //example
    // 字符 -> 索引列表
    HashMap<Character, List<Integer>> charToIndex = new HashMap<>();

    int dp(String ring, int i, String key, int j) {
        // printIndent(count++);
        // printf("i = %d, j = %d\n", i, j);

        if (j == key.length()) {
            // printIndent(--count);
            // printf("return 0\n");
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k : charToIndex.get(key.charAt(j))) {
            res = Math.min(res, dp(ring, j, key, i + 1));
        }

        // printIndent(--count);
        // printf("return %d\n", res);
        return res;
    }
}

