package leetcode;

import java.util.*;

//offer2q032

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
//            String orderStr = strArr.toString();//错误写法
            String orderStr = new String(strArr);
            if (!map.containsKey(orderStr)) {
                map.put(orderStr, new LinkedList<String>());
            }
            map.get(orderStr).add(str);
        }

        List<List<String>> res = new LinkedList<>();
        for (String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}