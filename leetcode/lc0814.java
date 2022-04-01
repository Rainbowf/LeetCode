package leetcode;

import java.util.*;

//offer2q047

class Solution0814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //后序遍历
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}