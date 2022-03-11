package leetcode;

import java.util.*;

class Solution0443 {
    private char[] gines = {'A', 'C', 'G', 'T'};

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch : gines) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    //单向
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(Arrays.asList(bank));

        int length = 0;
        queue1.add(start);

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(end)) {
                return length;
            }
            //1、生成邻居字符串
            List<String> neighbors = getNeighbors(word);
            //2、遍历查找邻居（是否在给定的字符串集合中，可能有多个）
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }
            //3、若该层遍历完了，则距离+1，更新queue1为queue2
            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    //双向
    public int minMutation2(String start, String end, String[] bank) {
        Set<String> notVisited = new HashSet<>(Arrays.asList(bank));

        if (!notVisited.contains(end)) {
            return -1;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 1;
        set1.add(start);
        set2.add(end);

        notVisited.remove(end);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            //1、比较大小，选择小的开始遍历
            if (set2.size() < set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            //2、创建下一层的set
            Set<String> set3 = new HashSet<>();
            //3、遍历set1中的节点
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                //遍历set1中的节点的邻居节点
                for (String neighbor : neighbors) {
                    //4、终止条件
                    if (set2.contains(neighbor)) {
                        return length;
                    }
                    //5、如果没有终止，将在集合中的邻居节点添加到下一层，并在集合中删除
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            //6、遍历set1结束，length+1
            length++;
            set1 = set3;
        }
        return -1;
    }
}