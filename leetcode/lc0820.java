package leetcode;

import java.util.*;

//offer2q065

class Solution0820 {
    //构造前缀树
    class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = {0};

        dfs(root, 1, total);
        return total[0];
    }

    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }

    //构造前缀树，注意从每个单词的最后一个字符倒过来往前存储
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
        }
        return root;
    }
}
