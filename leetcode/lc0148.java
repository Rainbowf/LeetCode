package leetcode;

import java.util.*;

//offer2q077

class Solution0148 {
    public ListNode sortList(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) return head;

        //对半切分
        ListNode head1 = head;
        ListNode head2 = split(head);
        //两个分别排序
        head1 = sortList(head1);
        head2 = sortList(head2);

        //合并两个有序链表
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = (head1 == null) ? head2 : head1;
        return dummy.next;
    }

    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
}

