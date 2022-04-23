package leetcode;

import java.util.*;

class Solution0075 {
    //计数排序
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        //计数排序
        for (int num : nums) {
            counts[num]++;
        }
        //再次分布
        int i = 0;
        for (int j = 0; j < counts.length; j++) {
            while (counts[j] > 0) {
                nums[i++] = j;
                counts[j]--;
            }
        }
    }

    //单指针
    //交换函数
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void sortColors1(int[] nums) {
        int ptr = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                swap(nums,i,ptr);
                ptr++;
            }
        }
        for(int i = ptr; i < nums.length; i++){
            if(nums[i] == 1){
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }
}