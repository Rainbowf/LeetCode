package leetcode;

import java.util.*;

//offer2q052

class Solution0897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode first = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == null) {
                first = curr;
            } else {
                prev.right = curr;
            }
            prev = curr;
            curr.left = null;
            curr = curr.right;
        }
        return first;
    }

    // 输入一棵 BST，返回一个有序「链表」
    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先把左右子树拉平
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        root.right = right;
        // 左子树为空的话，就不用处理了
        if (left == null) {
            return root;
        }
        // 左子树非空，需要把根节点和右子树接到左子树末尾
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = root;

        return left;
    }

}
