package leetcode;

import java.util.*;

//offer2q070

class Solution0540 {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 2, 2, 3, 3};
        int[] nums3 = {2, 2, 3, 3, 4};
        System.out.println(singleNonDuplicate(nums2));
    }

    // 5:  0 1 2 3 4  k = 2
// 6： 0 1 2 3 4 5， k = 4
    public static int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length / 2;

        while (i <= j) {
            int m = i + (j - i) / 2;
            int k = 2 * m;
            if (k < nums.length - 1 && nums[k] != nums[k + 1]) {
                if (m == 0 || nums[k - 2] == nums[k - 1]) {
                    return nums[k];
                }
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate3(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-y8gh/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}