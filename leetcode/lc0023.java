package leetcode;

import java.util.*;

//offer2q078

class Solution0023 {
    //归并排序思路kn×logk   O(logk) 空间
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int endn) {
        //递归终止条件，只有一个
        if (start == endn - 1) {
            return lists[start];
        }

        //两个及以上，可以对半分开
        int mid = (start + endn) / 2; //需要验证计算
        ListNode node1 = mergeKLists(lists, start, mid);
        ListNode node2 = mergeKLists(lists, mid, endn);

        //合并两个有序链表
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

    //最小堆思路kn×logk  空间复杂度为 O(k)
    public ListNode mergeKLists1(ListNode[] lists) {
        //哑结点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        //构造最小堆,先插入<=k个(链表头结点）
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        //依次将堆顶元素取出，并后移一位插入，直至最小堆为空
        while (!minHeap.isEmpty()) {
            //取
            ListNode least = minHeap.poll();
            //移
            cur.next = least;
            cur = least;
            //插
            if (least.next != null) {
                minHeap.offer(least.next);
            }
        }
        return dummy.next;
    }
}

