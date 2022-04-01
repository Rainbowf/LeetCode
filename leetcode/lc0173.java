package leetcode;

import java.util.*;

//offer2q055
class BSTIterator {
    //有哪些变量
    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }
    //大循环while里面，就是找下一个节点
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int val = curr.val;
        curr = curr.right;

        return val;
    }

    public boolean hasNext() {
        //大循环的条件
        return curr != null || !stack.isEmpty();
    }
}
