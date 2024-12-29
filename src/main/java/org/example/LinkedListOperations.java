package org.example;


class MyNode {
    int data;
    MyNode next;

    MyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations {

    MyNode head;

    public void add(int data) {

        MyNode newNode = new MyNode(data);

        if (head == null) {
            head = newNode;
        } else {
            MyNode currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
        newNode.next = null;
    }

    public void display () {
        MyNode currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.print("null");
    }

    public void addFirst (int data) {
        MyNode newNode = new MyNode(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void deleteFirst () {
        if (head == null) {
            return;
        }

        head = head.next;

    }

    public void addLast (int data) {
        MyNode newNode = new MyNode(data);

        if (head == null) {
            head = newNode;
        } else {
            MyNode currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
            newNode.next = null;

        }
    }

    public void deleteLast () {

        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
        MyNode secondLastNode = head;
        MyNode lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
        }

    }

    public MyNode reverseRecursive(MyNode current) {

        if (current == null || current.next == null) {
            return current;
        }

        MyNode newHead = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return newHead;
    }

    public MyNode reverseLL (MyNode head) {

        MyNode prev = null;
        MyNode current = head;
        MyNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    public MyNode findMiddle (MyNode head) {
        MyNode hare = head;
        MyNode turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public MyNode deleteNthNodeFromTheEnd (MyNode head, int n) {

        if (head.next == null) {
            return null;
        }

        //size
        int size = 0;
        MyNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }

        int indexToSearch = size - n;
        MyNode prev = head;
        int i=1;
        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;

        return head;
    }

    public boolean isPalindrome(MyNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        MyNode middle = findMiddle(head);
        MyNode secondHalfStart = reverseLL(middle.next);

        MyNode firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;
    }



    public static void main(String[] args) {
        LinkedListOperations llo = new LinkedListOperations();

        llo.add(7);
        llo.add(9);
        llo.add(11);
        llo.add(11);
        llo.add(9);
        llo.add(8);

        llo.display();

//        System.out.println(" ");
//        llo.addFirst(5);
//        llo.display();
//
//        System.out.println(" ");
//        llo.addLast(17);
//        llo.display();
//
//        System.out.println(" ");
//        llo.deleteFirst();
//        llo.display();
//
//        System.out.println(" ");
//        llo.deleteLast();
//        llo.display();

        System.out.println(" ");
        llo.reverseLL(llo.head);
//        llo.reverseRecursive(llo.head);
        llo.display();
//        llo.deleteNthNodeFromTheEnd(llo.head, 2);
//        llo.display();

        System.out.println(llo.isPalindrome(llo.head));

    }


}


