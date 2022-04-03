package leetcode;

import java.util.*;

//offer2q060

class Solution0347 {
    public int[] topKFrequent(int[] nums, int k) {
        //计算哈希
        Map<Integer, Integer> numCnts = new HashMap<>();
        for (int num : nums) {
            numCnts.put(num, numCnts.getOrDefault(num, 0) + 1);
        }

        //逐个插入
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : numCnts.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        //结果打印
        int[] res = new int[minHeap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            res[i++] = entry.getKey();
        }
        return res;
    }
}