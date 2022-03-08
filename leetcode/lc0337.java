package leetcode;

import java.util.*;
/*
    4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。
    这就是动态规划里面的最优子结构
 */

class Solution0337 {
    //1、暴力递归 - 最优子结构
    public int rob(TreeNode root) {
        if (root == null) return 0;
        //4 个孙子偷的钱 + 爷爷的钱
        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        //... VS 两个儿子偷的钱
        return Math.max(money, rob(root.left) + rob(root.right));
    }
    //后续遍历dfs
    //2、记忆化 - 解决重复子问题（哈希表存储每个节点的钱）
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) return 0;
        //a.（如果存在的话）取出当前节点的钱
        if (memo.containsKey(root)) return memo.get(root);

        //b.(不存在)执行下面操作
        //4 个孙子偷的钱 + 爷爷的钱
        int money = root.val;
        if (root.left != null) {
            money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
        }
        if (root.right != null) {
            money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
        }
        //... VS 两个儿子偷的钱
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        //存进去当前节点的钱
        memo.put(root, result);
        return result;
    }
    //3、双序列（不偷+偷）
//    root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
//    root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;

    public int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        //当前不偷 = 左边（偷或不偷） + 右边（偷或不偷）
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //当前偷 = 左边不偷 + 右边不偷 + 当前节点值
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}