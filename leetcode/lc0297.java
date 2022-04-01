package leetcode;

import java.util.*;

//offer2q048

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        //前序遍历
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return root.val + "," + leftStr + "," + rightStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);
    }

    private TreeNode dfs(String[] nodeStrs, int[] i) {
        String str = nodeStrs[i[0]];
        i[0]++;

        if(str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(nodeStrs,i);
        node.right = dfs(nodeStrs,i);
        return node;
    }
}