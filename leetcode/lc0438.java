package leetcode;

import java.util.*;
//offer2q015
class Solution0438 {
    //滑动窗口+数组哈希
    public List<Integer> findAnagrams(String s1, String s2) {
        //1、结果构造
        List<Integer> res = new LinkedList<>();
        //2、边界情况
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2) return res;

        int[] cnts = new int[26];
        //3、初始化（短）+判断一次
        for (int i = 0; i < len2; i++) {
            cnts[s2.charAt(i) - 'a']++;
            cnts[s1.charAt(i) - 'a']--;
        }
        if (areAllZero(cnts)) {
            res.add(0);
        }
        //4、继续遍历，每次判断
        for (int i = len2; i < len1; i++) {
            cnts[s1.charAt(i) - 'a']--;
            cnts[s1.charAt(i - len2) - 'a']++;
            if (areAllZero(cnts)) {
                res.add(i - len2 + 1);
            }
        }
        return res;
    }

    private boolean areAllZero(int[] cnts) {
        for (int cnt : cnts) {
            if (cnt != 0) return false;
        }
        return true;
    }
}