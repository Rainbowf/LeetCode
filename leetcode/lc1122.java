package leetcode;

import java.util.*;

//offer2q075

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //计数
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (counts[j] > 0) {
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}