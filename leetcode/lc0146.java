package leetcode;

import java.util.*;

//offer2q031
class DulNode {
    public int key;
    public int value;
    public DulNode next;
    public DulNode prev;

    public DulNode(int k, int v) {
        key = k;
        value = v;
    }
}

class LRUCache {
    private DulNode head;
    private DulNode tail;
    private HashMap<Integer, DulNode> map;
    private int size;

    public LRUCache(int capacity) {
        head = new DulNode(-1, -1);
        tail = new DulNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = capacity;

        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DulNode node = map.get(key);
            moveToTail(node, node.value);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DulNode node = map.get(key);
            moveToTail(node, value);
        } else {
            if (map.size() == size) {
                map.remove(head.next.key);
                deleteNode(head.next);
            }
            DulNode node = new DulNode(key, value);
            insertToTail(node);
            map.put(key, node);
        }
    }

    private void moveToTail(DulNode node, int value) {
        deleteNode(node);
        node.value = value;
        insertToTail(node);
    }

    private void deleteNode(DulNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(DulNode node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }
}