package leetcode;

import java.util.*;

//offer2q032

class Solution0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
            cnts[t.charAt(i) - 'a']--;
        }

        for (int cnt : cnts) {
            if (cnt != 0) return false;
        }
        return true;
    }
}