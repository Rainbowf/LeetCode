package leetcode;

import java.util.*;

//offer2q021

class Solution0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode front = head, back = dummy;
        for(int i = 0; i < n; i++){
            front = front.next;
        }
        while (front!=null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}