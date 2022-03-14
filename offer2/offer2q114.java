package offer2;

import java.util.*;

class Solution114 {

    public String alienOrder(String[] words) {
        //1、构建图、入度数组
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        //初始化图、入度
        for(String word : words){
            for (char ch: word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        //比较两个字符串，填图
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i+1];
            //特殊情况
            if(a.startsWith(b) && !a.equals(b)){
                return "";
            }

            int m = a.length();
            int n = b.length();

            for (int j = 0; j < Math.min(m, n); j++) {
                char ch1 = a.charAt(j);
                char ch2 = b.charAt(j);
                if (ch1 != ch2) {
                    if(!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;//一定要中断，后面就不比较了
                }
            }
        }

        //生成拓扑序列  O(m)
        Queue<Character> queue = new LinkedList<>();
        for (char ch : graph.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char from = queue.remove();
            sb.append(from);
            for (char next : graph.get(from)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return sb.length() == inDegrees.size() ? sb.toString() : "";
    }
}
/*
设words数组长度为m，每个word的平均长度为n
对于建图，需要枚举每个word的每个字符，因此时间复杂度为O(m*n)
该图的节点数为words中出现的不同的字符数，设为v
words的每组相邻元素最多形成1条边，因此该图的边数为O(m),空间复杂度为O(v+m);
对于拓扑排序，需要遍历所有节点O(v)和所有节点O(m)，综合复杂度是O(v+m)
综上，总时间复杂度是O(max(m*n,m+v))

作者：tandztc
链接：https://leetcode-cn.com/problems/Jf1JuT/solution/you-xiang-tu-yu-tuo-bu-pai-xu-he-ben-ti-4tk7e/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */