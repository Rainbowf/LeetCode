package leetcode;

import java.util.*;

//offer2q044

class Solution0515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        List<Integer> ans = new LinkedList<>();

        if (root != null) {
            queue1.offer(root);
        }
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode curr = queue1.poll();
            max = Math.max(max, curr.val);

            if (curr.left != null) {
                queue2.offer(curr.left);
            }
            if (curr.right != null) {
                queue2.offer(curr.right);
            }
            if (queue1.isEmpty()) {
                ans.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return ans;
    }
}