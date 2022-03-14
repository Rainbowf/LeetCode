package leetcode;
import java.util.*;
/*
这一题给定图没有环！
1. 反向变形BFS：
反向：从叶节点开始，往根BFS。
叶：degree=1的点，没有环保证开始时一定有叶。
变形：这里层不是直线切一层，而是曲线切一层，所有叶节点为一层。
2. 更新degree
每次BFS队列取一个节点，该节点邻居degree--，邻居节点degree变1时，转为新的“叶节点”，加入队列
 */
class Solution0310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // corner case: 只有一个节点
        if (n == 1) {
            res.add(0);
            return res;
        }
        //构建图,edges转邻接表，并初始化degree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new LinkedList<Integer>());
        }

        int[] inDegrees = new int[n];
        for (int[] temp : edges) {
            graph.get(temp[1]).add(temp[0]);//入度
            graph.get(temp[0]).add(temp[1]);
            inDegrees[temp[0]]++;
            inDegrees[temp[1]]++;
        }

        //添加所有入度为1的点,叶子节点,初始化BFS队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            //出度为1 的的为同一层，需要出队列，最后剩下的就是结果
            for(int i = 0; i < size; i++){
                int node = queue.remove();
                res.add(node);

                for (int next : graph.get(node)) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 1) {
                        queue.add(next);
                    }
                }
            }
        }
        return res;
    }
}