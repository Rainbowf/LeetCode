/**
  * 题目Id：918
  * 题目：环形子数组的最大和
  * 日期：2022-08-26 10:45:07
*/
//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
// Related Topics队列 | 数组 | 分治 | 动态规划 | 单调队列 
//
// 👍 398, 👎 0 
//
//
//
//

package leetcode.editor.cn;
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] A) {
            int len = A.length;
            int n = 2 * len;
            int[] nums = new int[n];
            //扩展成两倍
            for(int i = 0; i < len; i++){
                nums[i] = A[i];
                nums[i + len] = A[i];
            }
            // 求前缀和 下标从1开始
            int[] sum = new int[n + 1];
            for(int i = 1; i <= n; i++){
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            Deque<Integer> queue = new ArrayDeque<>();
            queue.addLast(0);// 边界，前0个数和是0
            int res = Integer.MIN_VALUE;// 有可能是负数，而子数组非空，所以初始值不能是0
            for(int i = 1; i <= n; i++){
                // 队头元素什么时候滑出
                if(queue.size() > 0 && queue.peekFirst() < i - len){
                    queue.pollFirst();
                }
                // 更新答案 这个队列是单调上升的，队首就是最小值sj。
                if(queue.size() > 0){
                    res = Math.max(res, sum[i] - sum[queue.peekFirst()]);
                }
                // 维护单调上升：如果新进来的元素比队尾的要小，就删除队尾
                while(queue.size() > 0 && sum[queue.peekLast()] >= sum[i]){
                    queue.pollLast();
                }
                // 新元素入队（队列里存的是下标）
                queue.addLast(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 