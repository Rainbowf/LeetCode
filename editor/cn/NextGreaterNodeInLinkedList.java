/**
  * 题目Id：1019
  * 题目：链表中的下一个更大节点
  * 日期：2022-08-26 10:09:44
*/
//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
// Related Topics栈 | 数组 | 链表 | 单调栈 
//
// 👍 210, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> array = new ArrayList<Integer>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            while (!stack.isEmpty() && array.get(i) > array.get(stack.peek())) {
                int last = stack.pop();
                res[last] = array.get(i);
            }
            stack.push(i);
            res[i] = 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 