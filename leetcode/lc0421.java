package leetcode;

import java.util.*;

//offer2q067

class Solution0421 {

    static class TrieNode {
        TrieNode children[];

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

//    private TrieNode root;

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode curr = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[1 - bit] == null) {
                    xor = xor << 1;
                    curr = curr.children[bit];
                } else {
                    xor = (xor << 1) + 1;
                    curr = curr.children[1 - bit];
                }
                curr = curr.children[bit];
            }
            max = Math.max(max, xor);
        }
        return max;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }
        return root;
    }
}