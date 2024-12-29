package org.example;

    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }


    class CreateLinkedList {
        static Node head;

        public void add (int data) {
            Node newNode = new Node(data);
            newNode.next = null;

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }


        public void display() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println(current);
        }

        public void reverse () {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;

        }


        public void reverseLinkedList () {

            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;

        }


        public static void main(String[] args) {
            CreateLinkedList createLinkedList = new CreateLinkedList();

            createLinkedList.add(1);
            createLinkedList.add(2);
            createLinkedList.add(3);
            createLinkedList.add(4);
            createLinkedList.add(5);

            System.out.println("Original List: ");
            createLinkedList.display();

            System.out.println(" ");

            createLinkedList.reverseLinkedList();

            System.out.println("Reversed list: ");
            createLinkedList.display();

//            System.out.println(createLinkedList.reverseLinkedList(head));
//            createLinkedList.reverseLinkedList(head);
//
//            System.out.println("Reversed Linked list: ");
//            createLinkedList.display(head);




        }



    }

