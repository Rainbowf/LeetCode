package leetcode;

import java.util.*;

class Solution0126 {
    //还没做
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        //单向广度搜索
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);

        queue1.add(beginWord);

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            temp.add(new String(word));

            if (word.equals(endWord)) {
                res.add(new LinkedList<>(temp));
                temp.remove(word);
                continue;
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
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }

        }
        return res;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}