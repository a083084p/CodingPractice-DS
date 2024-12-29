package org.example;

// Node.java
class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;
    DoublyNode child;

    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

public class MultiLevelDoublyLinkedListRecursive {
    DoublyNode head;

    // Flatten the list starting from the head
    public void flatten() {
        flattenList(head);
    }

    private DoublyNode flattenList(DoublyNode node) {
        DoublyNode current = node;
        DoublyNode tail = node; // Keep track of the last processed node

        while (current != null) {
            DoublyNode next = current.next; // Save next node

            if (current.child != null) {
                DoublyNode child = current.child;

                // Recursively flatten the child list
                DoublyNode childTail = flattenList(child);

                // Link current node to child
                current.next = child;
                child.prev = current;

                // If next was not null, link child's tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Clear the child pointer
                current.child = null;

                // Update the tail to the child's tail
                tail = childTail;
            } else {
                tail = current;
            }

            // Move to the next node
            current = next;
        }

        return tail;
    }

    // Utility method to add a node at the end of the list
    public void add(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Utility method to print the list
    public void printList() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility method to add a child to a node
    public void addChild(DoublyNode parent, int childData) {
        DoublyNode child = new DoublyNode(childData);
        parent.child = child;
    }

    public static void main(String[] args) {
        MultiLevelDoublyLinkedListRecursive list = new MultiLevelDoublyLinkedListRecursive();

        // Creating the list as in the example
        list.add(1);
        list.add(2);
        list.add(3);

        DoublyNode node2 = list.head.next;

        list.addChild(node2, 4);
        DoublyNode node4 = node2.child;
        list.addChild(node4, 5);
        DoublyNode node5 = node4.child;
        list.addChild(node5, 6);

        System.out.println("Original multi-level list:");
        list.printList();

        // Flattening the list
        list.flatten();

        System.out.println("Flattened list:");
        list.printList();
    }
}
