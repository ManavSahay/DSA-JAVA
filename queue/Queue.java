package queue;

import java.util.Scanner;

public class Queue {
    static int MAX_SIZE = 5;
    static int front = -1;
    static int rear = -1;

    static void push(int[] queue, int data) {
        rear++;
        if (rear >= MAX_SIZE) {
            rear--;
            System.out.println("Overflow!");
            return;
        }
        queue[rear] = data;
    }

    static int remove(int[] queue) {
        front++;
        if (front > rear) {
            front--;
            return -1;
        }
        return queue[front];
    }

    static void printQueue(int[] queue) {
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] queue = new int[MAX_SIZE];
        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Print");
            System.out.println("4. Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter element to be pushed: ");
                    push(queue, sc.nextInt());
                }
                case 2 -> {
                    int poppedElement = remove(queue);
                    if (poppedElement == -1) {
                        System.out.println("Underflow!");
                    }
                    else {
                        System.out.println("The popped element is: " + poppedElement);
                    }
                }
                case 3 -> printQueue(queue);
                case 4 -> System.out.println("Exiting!");
                default -> System.out.println("Invalid!");
            }
        } while (choice != 4);
    }
}
