package leetcode;

import java.util.*;


class Solution1004 {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] nums2 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(nums2, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int[] cnts = new int[2];
        int res = Integer.MIN_VALUE;

        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) k--;
            if (k < 0 && nums[l++] == 0) k++;
        }
        return r - l;
    }
}