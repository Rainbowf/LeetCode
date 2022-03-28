package leetcode;

//offer2q029

// Definition for a Node.
class Node2 {
    public int val;
    public Node2 next;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _next) {
        val = _val;
        next = _next;
    }
};


class Solution029 {
    public Node2 insert(Node2 head, int insertVal) {
        //创建新节点
        Node2 node = new Node2(insertVal);
        //case1
        if (head == null) {
            head = node;
            node.next = node;
        } else if (head.next == null) {
            //case2
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private void insertCore(Node2 head, Node2 node2) {
        Node2 cur = head;
        Node2 next = cur.next;
        Node2 biggest = head;
        //只转一圈
        while (!(cur.val <= node2.val && next.val >= node2.val) && next != head) {
            cur = next;
            next = next.next;
            if(cur.val >= biggest.val){
                biggest = cur;
            }
        }
        if (cur.val <= node2.val && next.val >= node2.val){
            cur.next = node2;
            node2.next = next;
        }else {
            node2.next = biggest.next;
            biggest.next = node2;
        }
    }
}