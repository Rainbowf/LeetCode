package leetcode;

import java.util.*;


class Solution0912 {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] src = nums;           //源
        int[] dst = new int[length];//目的
        //自下而上
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {

                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);

                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            //每次排序需要交换
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;
    }

    public int[] sortArray2(int[] nums) {
        int[] dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start >= end - 1) {
            return;//?
        }

        int mid = (start + end) / 2;
        mergeSort(dst, src, start, mid);
        mergeSort(dst, src, mid, end);

        int i = start, j = mid, k = start;
        while (i < mid || j < end){
            if(j == end || (i < mid && src[i] < src[j])){
                dst[k++] = src[i++];
            }else {
                dst[k++] = src[j++];
            }
        }
    }
}