package leetcode;

import java.util.*;
//offer2q017

class Solution0076 {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        //1、边界情况
        if (len1 < len2) return "";
        //2、中间变量
        Set<Character> set = new HashSet<>();
        int[] map = new int[256];
        int kindNum = set.size();
        int minLen = Integer.MAX_VALUE;
        //3、初始化
        for (int i = 0; i < len2; i++) {
            map[t.charAt(i)]++;
            set.add(t.charAt(i));//去重
        }
        //4、遍历（滑动窗口）
        int maxI = 0;
        int minJ = 0;
        int i = 0, j = 0;
        while (j < len1 || (kindNum == 0 && j == len1)) {
            //没有全部包含，j向右扩充
            if (kindNum > 0) {
                if (set.contains(s.charAt(j))) {
                    map[s.charAt(j)]--;
                    if (map[s.charAt(j)] == 0) {
                        kindNum--;
                    }
                }
                j++;
                //全部包含了，i向右收缩（i和j左闭右开）
            } else {
                //先保存最小长度结果
                if (j - i < minLen) {
                    minLen = j - i;
                    maxI = i;
                    minJ = j;
                }

                if (set.contains(s.charAt(i))) {
                    map[s.charAt(i)]++;
                    if (map[s.charAt(i)] == 1) {
                        kindNum++;
                    }
                }
                i++;
            }
        }

        return minLen < Integer.MAX_VALUE ? s.substring(maxI, minJ) : "";
    }
}