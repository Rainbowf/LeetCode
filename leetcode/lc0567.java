package leetcode;

import java.util.*;
//offer2q014

class Solution0567 {
    //滑动窗口+数组哈希
    //s1端，s2长
    public boolean checkInclusion(String s1, String s2) {
        //1、非法情况
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        //2、构造临时变量存储
        int[] cnts = new int[26];
        //3、初始化（短）+判断一次
        for (int i = 0; i < len1; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(cnts)) {
            return true;
        }
        //4、继续遍历，每次判断
        for (int i = len1; i < len2; i++) {
            cnts[s2.charAt(i) - 'a']--;
            cnts[s2.charAt(i - len1) - 'a']++;
            if (areAllZero(cnts)){
                return true;
            }
        }
        return false;
    }

    private boolean areAllZero(int[] cnts) {
        for (int cnt : cnts) {
            if (cnt != 0) return false;
        }
        return true;
    }
}