package leetcode;

import java.util.*;

//offer2q034

class Solution0953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictOrder = new int[26];
        for(int i = 0; i < 26; i++){
            dictOrder[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < words.length - 1; i++){
            if(!isOreder(words[i],words[i+1],dictOrder)){
                return false;
            }
        }
        return true;
    }

    private boolean isOreder(String word1, String word2, int[] dictOrder) {
        int j = 0;
        for(; j < word1.length() && j < word2.length(); j++){
            int ch1 = word1.charAt(j) - 'a';
            int ch2 = word2.charAt(j) - 'a';
            if(dictOrder[ch1] < dictOrder[ch2]){
                return true;
            }else if(dictOrder[ch1] > dictOrder[ch2]){
                return false;
            }
        }
        return j == word1.length();
    }
}