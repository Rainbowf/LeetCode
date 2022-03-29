package leetcode;

import java.util.*;

//offer2q022
class Solution0142 {

    public ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = slow.next;

        while (fast != null && slow != null) {
            if (fast == slow) return slow;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) return null;

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }
}