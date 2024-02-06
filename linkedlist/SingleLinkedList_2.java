package linkedlist;

import java.util.Scanner;

public class SingleLinkedList_2 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void insertMiddle(int data, int position) {
        Node currentNode = head;
        Node newNode = new Node(data);
        Node temp = new Node(-1);

        for (int i = 0; i < position - 1; i++) {
            currentNode = currentNode.next;
            temp = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.next = temp;
    }

    public void deleteFirst() {
        head = head.next;
    }

    public void deleteLast() {
        Node currentNode = head;
        Node temp = new Node(-1);
        while (currentNode.next != null) {
            temp = currentNode;
            currentNode = currentNode.next;
        }
        temp.next = null;
    }

    public void deleteMiddle(int position) {
        Node currentNode = head;
        Node temp;
        Node temp1 = new Node(-1);

        for (int i = 0; i < position - 1; i++) {
            currentNode = currentNode.next;
            temp = currentNode.next;
            temp1 = temp.next;
        }

        currentNode.next = temp1;
    }

    public void reverseList() {
        Node currentNode = head;
        Node temp1 = currentNode.next;
        Node temp2 = temp1.next;

        while (temp2 != null) {
            temp1.next = currentNode;
            currentNode = temp1;
            temp1 = temp2;
            temp2 = temp2.next;
        }
        temp1.next = currentNode;
        head.next = null;
        head = temp1;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SingleLinkedList_2 list = new SingleLinkedList_2();

        System.out.println("Enter length of the list: ");
        int length = sc.nextInt();

        System.out.println("Enter the data: ");
        for (int i = 0; i < length; i++) {
            list.add(sc.nextInt());
        }

        int choice;
        do {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Print List");
            System.out.println("4. Reverse");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    int insCh, position, data = -1;
                    do {
                        System.out.println("1. Insert First");
                        System.out.println("2. Insert Last");
                        System.out.println("3. Insert Middle");
                        System.out.println("4. Exit");
                        insCh = sc.nextInt();

                        switch (insCh) {
                            case 1 -> {
                                System.out.println("Enter data: ");
                                data = sc.nextInt();
                                list.insertFirst(data);
                            }
                            case 2 -> {
                                System.out.println("Enter data: ");
                                data = sc.nextInt();
                                list.insertLast(data);
                            }
                            case 3 -> {
                                System.out.println("Enter data: ");
                                data = sc.nextInt();
                                System.out.println("Enter position");
                                position = sc.nextInt();
                                list.insertMiddle(data, position);
                            }
                        }
                    } while (insCh != 4);
                }
                case 2 -> {
                    int insCh, position;
                    do {
                        System.out.println("1. Delete First");
                        System.out.println("2. Delete Last");
                        System.out.println("3. Delete Middle");
                        System.out.println("4. Exit");
                        insCh = sc.nextInt();

                        switch (insCh) {
                            case 1 -> list.deleteFirst();
                            case 2 -> list.deleteLast();
                            case 3 -> {
                                System.out.println("Enter position: ");
                                position = sc.nextInt();
                                list.deleteMiddle(position);
                            }
                        }
                    } while (insCh != 4);
                }
                case 3 -> list.printList();
                case 4 -> list.reverseList();
                case 5 -> System.out.println("Exiting!");
                default -> System.out.println("Invalid!");
            }
        } while(choice != 5);
    }
}
