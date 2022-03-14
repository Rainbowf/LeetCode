package leetcode;

class Solution0318 {
    public int maxProduct(String[] words) {
        //1、存到数组中
        int res = 0;
        int[] bitnum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                bitnum[i] |= 1 << (ch - 'a');
            }
        }
        //2、两两比较
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                //注意括号
                if ((bitnum[i] & bitnum[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}