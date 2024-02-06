package linkedlist;

import java.util.Scanner;

public class DoubleLinkedList {
    Node head = null;

    class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
            this.previous = null;
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
            Node temp = head;
            while (currentNode.next != null) {
                temp = currentNode;
                currentNode = currentNode.next;
            }
            newNode.previous = currentNode;
            currentNode.next = newNode;
        }
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.previous = current;
    }

    public void insertMiddle(int position, int data) {
        Node newNode = new Node(data);
        Node current = head, temp = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            temp = current.next;
        }
        newNode.previous = current;
        newNode.next = temp;
        temp.previous = newNode;
        current.next = newNode;
    }

    public void deleteFirst() {
        Node current = head.next;
        current.previous = null;
        head = current;
    }

    public void deleteLast() {
        Node temp = null, current = head;
        while (current.next != null) {
            temp = current;
            current = current.next;
        }
        temp.next = null;
    }

    public void deleteMiddle(int position) {
        Node temp1 = null, temp2 = null, current = head;
        for (int i = 0; i < position; i++) {
            temp1 = current;
            current = current.next;
            temp2 = current.next;
        }
        temp1.next = temp2;
        temp2.previous = temp1;
    }

    public void printList() {
        Scanner sc = new Scanner(System.in);
        Node currentNode = head;
        int choice;
        do {
            System.out.println("----------------");
            System.out.println("How to print: ");
            System.out.println("1. From start");
            System.out.println("2. From End");
            System.out.println("3. Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    while (currentNode != null) {
                        System.out.print(currentNode.data + " --> ");
                        currentNode = currentNode.next;
                    }
                    System.out.println("NULL");
                }
                case 2 -> {
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    while (currentNode != null) {
                        System.out.print(currentNode.data + " --> ");
                        currentNode = currentNode.previous;
                    }
                    System.out.println("NULL");
                }
                case 3 -> System.out.println("Exiting!");
                default -> System.out.println("Invalid!");
            }
            currentNode = head;
            System.out.println("----------------");
        } while(choice != 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoubleLinkedList list = new DoubleLinkedList();

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
            System.out.println("4. Exit");
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
                                list.insertMiddle(position, data);
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
                case 4 -> System.out.println("Exiting!");
                default -> System.out.println("Invalid!");
            }
        } while(choice != 4);
    }
}
