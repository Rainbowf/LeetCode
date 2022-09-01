<p><strong>完全二叉树</strong> 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。</p>

<p>设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。</p>

<p>实现 <code>CBTInserter</code> 类:</p>

<ul>
	<li><code>CBTInserter(TreeNode root)</code>&nbsp;使用头节点为&nbsp;<code>root</code>&nbsp;的给定树初始化该数据结构；</li>
	<li><code>CBTInserter.insert(int v)</code>&nbsp; 向树中插入一个值为&nbsp;<code>Node.val == val</code>的新节点&nbsp;<code>TreeNode</code>。使树保持完全二叉树的状态，<strong>并返回插入节点</strong>&nbsp;<code>TreeNode</code>&nbsp;<strong>的父节点的值</strong>；</li>
	<li><code>CBTInserter.get_root()</code> 将返回树的头节点。</li>
</ul>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/08/03/lc-treeinsert.jpg" style="height: 143px; width: 500px;" /></p>

<pre>
<strong>输入</strong>
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
<strong>输出</strong>
[null, 1, 2, [1, 2, 3, 4]]

<strong>解释</strong>
CBTInserter cBTInserter = new CBTInserter([1, 2]);
cBTInserter.insert(3);  // 返回 1
cBTInserter.insert(4);  // 返回 2
cBTInserter.get_root(); // 返回 [1, 2, 3, 4]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数量范围为&nbsp;<code>[1, 1000]</code>&nbsp;</li>
	<li><code>0 &lt;= Node.val &lt;= 5000</code></li>
	<li><code>root</code>&nbsp;是完全二叉树</li>
	<li><code>0 &lt;= val &lt;= 5000</code>&nbsp;</li>
	<li>每个测试用例最多调用&nbsp;<code>insert</code>&nbsp;和&nbsp;<code>get_root</code>&nbsp;操作&nbsp;<code>10<sup>4</sup></code>&nbsp;次</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 设计 | 二叉树</details><br>

<div>👍 145, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题考察二叉树的层序遍历，你需要先做 [102. 二叉树的层序遍历](/problems/binary-tree-level-order-traversal) 再做这道题，用队列维护底部可以进行插入的节点即可。

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class CBTInserter {
    // 这个队列只记录完全二叉树底部可以进行插入的节点
    private Queue<TreeNode> q = new LinkedList<>();
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        // 进行普通的 BFS，目的是找到底部可插入的节点
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while (!temp.isEmpty()) {
            TreeNode cur = temp.poll();
            if (cur.left != null) {
                temp.offer(cur.left);
            }
            if (cur.right != null) {
                temp.offer(cur.right);
            }
            if (cur.right == null || cur.left == null) {
                // 找到完全二叉树底部可以进行插入的节点
                q.offer(cur);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur = q.peek();
        // 进行插入
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
            q.poll();
        }
        // 新节点的左右节点也是可以插入的
        q.offer(node);
        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
```

</details>
</div>



