package leetcode;

import java.util.*;

//offer2q056
//lc0173正向迭代器
//建立一个反向的
class BSTIteratorReversed {

    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIteratorReversed(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    public int prev() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;//先右边
        }
        curr = stack.pop();
        int val = curr.val;
        curr = curr.left;//再 左边

        return val;
    }

    public boolean hasPrev() {
        return curr != null || !stack.isEmpty();
    }
}

//两数之和，两种解法：双指针 + 哈希表
class Solution0653 {
    //双指针：利用两个迭代器
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);

        int next = iterNext.next();
        int prev = iterPrev.prev();

        while (next != prev) {
            if (next + prev == k) {
                return true;
            } else if (next + prev < k) {
                next = iterNext.next();
            } else {
                prev = iterPrev.prev();
            }
        }
        return false;
    }

        //哈希表解法,O(n)
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            //处理
            if (set.contains(k - curr.val)) {
                return true;
            }
            set.add(curr.val);

            curr = curr.right;
        }
        return false;
    }
}
