package offer2;

import java.util.*;

class Solution078 {
    //最小堆思路
    public ListNode mergeKLists1(ListNode[] lists) {
        //哑结点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        //构造最小堆,先插入<=k个
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        //依次将堆顶元素取出，并后移一位插入，直至最小堆为空
        while (!minHeap.isEmpty()) {
            ListNode least = minHeap.poll();
            cur.next = least;
            cur = least;

            if (least.next != null) {
                minHeap.offer(least.next);
            }
        }
        return dummy.next;
    }

    //归并排序思路
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        ListNode node1 = mergeLists(lists, start, mid);
        ListNode node2 = mergeLists(lists, mid, end);
        return merge(node1, node2);
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //原理 和 合并两个数组类似
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
}