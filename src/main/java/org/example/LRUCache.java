package org.example;

// File path: LRUCache.java

import java.util.HashMap;

class LRUNode {
    int key;
    int value;
    LRUNode prev;
    LRUNode next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    private LRUNode head;
    private LRUNode tail;

    public DoublyLinkedList() {
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNodeToFront(LRUNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(LRUNode node) {
        removeNode(node);
        addNodeToFront(node);
    }

    public LRUNode removeLastNode() {
        if (tail.prev == head) {
            return null; // List is empty
        }
        LRUNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
}

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, LRUNode> cache;
    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }
        LRUNode node = cache.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LRUNode node = cache.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (cache.size() == capacity) {
                LRUNode lastNode = dll.removeLastNode();
                if (lastNode != null) {
                    cache.remove(lastNode.key);
                }
            }
            LRUNode newNode = new LRUNode(key, value);
            dll.addNodeToFront(newNode);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}

