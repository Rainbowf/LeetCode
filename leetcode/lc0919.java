package leetcode;

import java.util.*;

//offer2q043

class CBTInserter {
    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;

        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right!=null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int val) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(val);

        if(parent.left == null){
            parent.left = node;
        }else {
            parent.right = node;

            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}