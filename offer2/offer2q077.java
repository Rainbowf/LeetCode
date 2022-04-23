package offer2;

import java.util.*;

class Solution077 {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] src = nums;           //源
        int[] dst = new int[length];//目的
        //自下而上
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {

                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);

                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            //每次排序需要交换
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;
    }

    public int[] sortArray2(int[] nums) {
        int[] dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        //左闭右开
        if (start + 1 >= end) {
            dst[start] = src[start];
        }

        int mid = (start + end) / 2;
        mergeSort(src, dst, start, mid);
        mergeSort(src, dst, mid, end);

        int i = start, j = mid, k = start;
        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }


    public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);

        // 3、当前层业务操作（合并有序链表）
        return merge(head1, head2);
    }

    //双指针找到链表中间节点（876. 链表的中间结点）
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