package leetcode;

import java.util.*;

//offer2q027

class Solution0234 {
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

    //快慢双指针，先找中点，再翻转
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        //对半分，快慢双指针
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        //拆开
        ListNode secList = slow.next;
        slow.next = null;
        //拼接
        secList = reverseList(secList);
        ListNode firList = head;

        while (firList != null && secList != null) {
            if (firList.val != secList.val) {
                return false;
            }
            firList = firList.next;
            secList = secList.next;
        }
        return true;
    }
}