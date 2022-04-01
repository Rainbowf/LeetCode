package leetcode;

import java.util.*;

//offer2q046

class Solution0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resView = new LinkedList<>();

        if (root == null) {
            return resView;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                resView.add(node.val);

                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return resView;
    }
}