package leetcode;

import java.util.*;

//offer2q063

class Solution0648 {
    //先定义字典树节点
    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        //构建字典树
        TrieNode root = new TrieNode();
        for (String prefix : dictionary) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;
        }
        //逐个转换
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            words[i] = prefix.isEmpty() ? words[i] : prefix;
        }
        return String.join(" ", words);
    }

    //替换词，返回替换结果
    private String findPrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (curr.isWord || curr.children[ch - 'a'] == null) {
                break;
            }
            builder.append(ch);
            curr = curr.children[ch - 'a'];
        }
        return curr.isWord ? builder.toString() : "";
    }
}