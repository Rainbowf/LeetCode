package leetcode;

import java.util.*;

//offer2q076

class Solution0215 {
    private int partition(int[] nums, int start, int end) {
        //产生随机，左右边界可取到
        Random random = new Random();
        int rand = random.nextInt(end - start + 1) + start;
        swap(nums, rand, end);

        //快排核心代码
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;//小部分边界右移
                swap(nums, i, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);

        while (index != target) {
            if (index > target) {
                end = index - 1;

            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }
}