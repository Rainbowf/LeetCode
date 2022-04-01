package leetcode;


import java.time.temporal.Temporal;
import java.util.*;

//offer2q045

class Solution0513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        if (root != null) {
            que1.offer(root);
        }
        int botLeft = root.val;
        while (!que1.isEmpty()) {
            TreeNode curr = que1.poll();
            if (curr.left != null) {
                que2.offer(curr.left);
            }
            if (curr.right != null) {
                que2.offer(curr.right);
            }
            if (que1.isEmpty()) {
                que1 = que2;
                que2 = new LinkedList<>();
                if (!que1.isEmpty()) {
                    botLeft = que2.peek().val;
                }
            }
        }
        return botLeft;
    }
}