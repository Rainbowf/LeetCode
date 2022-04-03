package leetcode;

import java.util.*;

//offer2q064

class MagicDictionary {
    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    private boolean dfs(TrieNode root, String searchWord, int i, int flag) {
        if (root == null) {
            return false;
        }
        if (root.isWord && i == searchWord.length() && flag == 1) {
            return true;
        }
        if (i < searchWord.length() && flag <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int nextFlag = (j == searchWord.charAt(i) - 'a') ? flag : flag + 1;
                found = dfs(root.children[j], searchWord, i + 1, nextFlag);
            }
            return found;
        }
        return false;
    }


}