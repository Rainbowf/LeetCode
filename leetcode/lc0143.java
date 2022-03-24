package leetcode;

import java.util.*;

//offer2q026

class Solution0143 {
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        ListNode secList = slow.next;
        slow.next = null;

        secList = reverseList(secList);

        ListNode firList = head;

        while (firList != null && secList != null) {
            ListNode next1 = firList.next;
            ListNode next2 = secList.next;

            firList.next = secList;
            secList.next = next1;

            firList = next1;
            secList = next2;
        }
    }

    public void reorderList2(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;

        while (i < j){
            list.get(i).next = list.get(j);
            i++;

            if(i == j){
                break;
            }

            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }
}