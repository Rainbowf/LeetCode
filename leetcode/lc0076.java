package leetcode;

import java.util.*;
//offer2q017

class Solution0076 {
    public String minWindow(String s, String t) {
        //长度
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) return "";
        int[] cnts = new int[256];
        Set<Character> set = new HashSet<>();

        //初始化
        for (char ch : t.toCharArray()) {
            set.add(ch);
            cnts[ch]++;
        }
        int kindNum = set.size();
        //结果
        //遍历查找
        int i = 0, j = 0;
        int maxI = 0, minJ = len1;
        int minLen = len1 + 1;
        while (j < s.length() || (j == s.length() && kindNum == 0)) {
            if (kindNum > 0) {
                if (set.contains(s.charAt(j))) {
                    cnts[s.charAt(j)]--;
                    if (cnts[s.charAt(j)] == 0) {
                        kindNum--;
                    }
                }
                j++;
            } else {
                //左闭右开
                if (j - i < minLen) {
                    minLen = j - i;
                    maxI = i;
                    minJ = j;
                }

                if (set.contains(s.charAt(i))) {
                    cnts[s.charAt(i)]++;
                    if (cnts[s.charAt(i)] == 1) {
                        kindNum++;
                    }
                }
                i++;
            }
        }
        return minLen == len1 + 1 ? "" : s.substring(maxI, minJ);
    }
}