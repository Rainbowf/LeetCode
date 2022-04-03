package leetcode;

import java.util.*;

//offer2q061

class Solution0373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //最大堆
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);

        //两层嵌套，注意只需要前k个
        for (int i = 0; i < k && i < nums1.length; i++) {
            for (int j = 0; j < k && j < nums2.length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else if (nums1[i] + nums2[j] < maxHeap.peek()[0] + maxHeap.peek()[1]) {
                    maxHeap.poll();
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }
            }
        }
        //结果输出
        List<List<Integer>> ans = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();//从最底层删除，也就是最小的
            ans.add(Arrays.asList(temp[0], temp[1]));
        }
        return ans;
    }

    //最小堆思路，复杂但省时间
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        //创建最小堆
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        //创建k个
        if (nums2.length > 0) {
            for (int i = 0; i < k && i < nums1.length; i++) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        //与nums2比较
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] temp = minHeap.poll();
            ans.add(Arrays.asList(nums1[temp[0]], nums2[temp[1]]));
            if (temp[1] < nums2.length - 1) {
                minHeap.offer(new int[]{temp[0], temp[1] + 1});
            }
        }
        return ans;
    }
}