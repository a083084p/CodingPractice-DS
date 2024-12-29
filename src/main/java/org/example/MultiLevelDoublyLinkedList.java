package org.example;

class MLDoublyNode {
    int data;
    MLDoublyNode prev;
    MLDoublyNode next;
    MLDoublyNode child;

    public MLDoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

// MultiLevelDoublyLinkedList.java
public class MultiLevelDoublyLinkedList {
    MLDoublyNode head;

    // Flatten the list iteratively starting from the head
    public void flatten() {
        if (head == null) return;

        MLDoublyNode current = head;

        while (current != null) {
            if (current.child != null) {
                MLDoublyNode child = current.child;
                MLDoublyNode next = current.next;

                // Link current node to child
                current.next = child;
                child.prev = current;
                current.child = null;

                // Traverse to the end of the child list
                MLDoublyNode tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Link the end of the child list to the next node
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }

            current = current.next;
        }
    }

    // Utility method to add a node at the end of the list
    public void add(int data) {
        MLDoublyNode newNode = new MLDoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            MLDoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Utility method to print the list
    public void printList() {
        MLDoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility method to add a child to a node
    public void addChild(MLDoublyNode parent, int childData) {
        MLDoublyNode child = new MLDoublyNode(childData);
        parent.child = child;
    }

    public static void main(String[] args) {
        MultiLevelDoublyLinkedList list = new MultiLevelDoublyLinkedList();

        // Creating the list as in the example
        list.add(1);
        list.add(2);
        list.add(3);

        MLDoublyNode node2 = list.head.next;

        list.addChild(node2, 4);
        MLDoublyNode node4 = node2.child;
        list.addChild(node4, 5);
        MLDoublyNode node5 = node4.child;
        list.addChild(node5, 6);

        System.out.println("Original multi-level list:");
        list.printList();

        // Flattening the list
        list.flatten();

        System.out.println("Flattened list:");
        list.printList();
    }
}
