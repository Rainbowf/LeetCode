package leetcode;

import java.util.*;

class Solution0886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //1、创建graph
        Map<Integer, List<Integer>> graph = buildGraph(n, dislikes);

        //2、涂色
        //创建每个节点的颜色表,0、1、-1:没有染色
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        //对每个节点进行 涂色
        for (int i = 1; i <= n; i++) {
            //只对还未染色的节点进行搜索，前面已经涂色的节点均为其他子图搜索完毕，因此可设置现在的节点颜色为0
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new LinkedList<>());
        }

        for (int[] dislike : dislikes) {
            //双向图
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        return graph;
    }

    //  深度优先搜索，递归
    private boolean setColor(Map<Integer, List<Integer>> graph, int[] colors, int i, int color) {
        //在这一轮中，可能会碰到重复涂色，即 闭环
        if (colors[i] >= 0) {
            return color == colors[i];
        }

        colors[i] = color;
        //对每一个邻居进行检查
        for (int neighbor : graph.get(i)) {
            if (!setColor(graph, colors, neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}