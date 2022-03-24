package leetcode;

import java.util.*;

//offer2q020

class Solution0647 {
    public int countSubstrings(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        int i = start, j = end;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}