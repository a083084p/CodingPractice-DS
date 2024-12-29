package org.example;

// File: MergeSortLinkedList.java

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle point to divide the list into two halves
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        middle.next = null;

        // Apply mergeSort on left list
        ListNode left = mergeSort(head);

        // Apply mergeSort on right list
        ListNode right = mergeSort(nextOfMiddle);

        // Merge the left and right lists
        ListNode sortedList = sortedMerge(left, right);
        return sortedList;
    }

    // Utility function to get the middle of the linked list
    public static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Utility function to merge two sorted linked lists
    public static ListNode sortedMerge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode result;

        if (left.val <= right.val) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(15);
        head.next = new ListNode(10);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println("Linked List before sorting:");
        printList(head);

        head = mergeSort(head);

        System.out.println("\nLinked List after sorting:");
        printList(head);
    }
}
