package offer2;

import java.util.*;

class Solution115 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        //1、构建图，入度数组
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (List<Integer> seq : seqs) {
            //初始化
            for (int num : seq) {
                //边界情况
                if (num < 1 || num > org.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }
            //填图
            for (int i = 0; i < seq.size() - 1; i++) {
                int from = seq.get(i);
                int to = seq.get(i + 1);
                if (!graph.get(from).contains(to)) {
                    graph.get(from).add(to);
                    inDegrees.put(to, inDegrees.get(to) + 1);
                }
            }
        }

        //2、生成拓扑序列
        //添加入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.add(num);
            }
        }
        //3、返回结果
        List<Integer> built = new LinkedList<>();
        //注意这里由于要判断是否唯一，所以queue中只能有一个
        while (queue.size() == 1) {
            int from = queue.remove();
            built.add(from);
            for (int next : graph.get(from)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        int[] result = built.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(result, org);
    }
}