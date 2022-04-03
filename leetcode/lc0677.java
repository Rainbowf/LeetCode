package leetcode;

import java.util.*;

//offer2q066

class MapSum {

    class TrieNode {
        TrieNode children[];
        int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch = 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.value = val;
    }

    public int sum(String prefix) {
        //先判断有没有prefix的
        TrieNode curr = root;

        for (char ch : prefix.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                return 0;
            }
            curr = curr.children[ch - 'a'];
        }
        return getSum(curr);
    }

    private int getSum(TrieNode curr) {
        if (curr == null) return 0;
        int ans = curr.value;
        for (TrieNode child : curr.children) {
            ans += getSum(child);
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */