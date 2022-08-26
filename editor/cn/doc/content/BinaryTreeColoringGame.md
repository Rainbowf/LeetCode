<p>有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点&nbsp;<code>root</code>，树上总共有 <code>n</code> 个节点，且 <code>n</code> 为奇数，其中每个节点上的值从&nbsp;<code>1</code> 到&nbsp;<code>n</code>&nbsp;各不相同。</p>

<p>&nbsp;</p>

<p>游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，</p>

<p>「一号」玩家从 <code>[1, n]</code>&nbsp;中取一个值&nbsp;<code>x</code>（<code>1 &lt;= x &lt;= n</code>）；</p>

<p>「二号」玩家也从&nbsp;<code>[1, n]</code>&nbsp;中取一个值&nbsp;<code>y</code>（<code>1 &lt;= y &lt;= n</code>）且&nbsp;<code>y != x</code>。</p>

<p>「一号」玩家给值为&nbsp;<code>x</code>&nbsp;的节点染上红色，而「二号」玩家给值为&nbsp;<code>y</code>&nbsp;的节点染上蓝色。</p>

<p>&nbsp;</p>

<p>之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 <strong>未着色 </strong>的邻节点（即左右子节点、或父节点）进行染色。</p>

<p>如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。</p>

<p>若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。</p>

<p>&nbsp;</p>

<p>现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个&nbsp;<code>y</code>&nbsp;值可以确保你赢得这场游戏，则返回&nbsp;<code>true</code>；若无法获胜，就请返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/04/1480-binary-tree-coloring-game.png" style="height: 186px; width: 300px;"></strong></p>

<pre><strong>输入：</strong>root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
<strong>输出：</strong>True
<strong>解释：</strong>第二个玩家可以选择值为 2 的节点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>二叉树的根节点为&nbsp;<code>root</code>，树上由 <code>n</code> 个节点，节点上的值从 <code>1</code> 到 <code>n</code> 各不相同。</li>
	<li><code>n</code> 为奇数。</li>
	<li><code>1 &lt;= x &lt;= n&nbsp;&lt;= 100</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 85, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；B 站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题的关键是要观察规律，根据游戏规则，对方先选一个节点之后，你的最优策略就是紧贴着对方的那个节点选择，也就是说你应该选择节点 `x` 的左右子节点或者父节点。

做出以上三种选择，你可以占据二叉树的不同部分，如下图：

![](https://labuladong.github.io/algo/images/短题解/1145.png)

你如果想赢，必须占据超过 `n / 2` 的节点，也就是说，如果这三个蓝色区域中节点数最多的那个区域中的节点个数大于 `n / 2`，你能赢，否则你就输。

所以本题转化为计算二叉树节点个数的简单问题，具体看代码逻辑。

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = find(root, x);
        int leftCount = count(node.left);
        int rightCount = count(node.right);
        int otherCount = n - 1 - leftCount - rightCount;

        return Math.max(leftCount, Math.max(rightCount, otherCount)) > n / 2;
    }

    // 定义：在以 root 为根的二叉树中搜索值为 x 的节点并返回
    TreeNode find(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        // 去左子树找
        TreeNode left = find(root.left, x);
        if (left != null) {
            return left;
        }
        // 左子树找不到的话去右子树找
        return find(root.right, x);
    }

    // 定义：计算以 root 为根的二叉树的节点总数
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
```

</details>
</div>



