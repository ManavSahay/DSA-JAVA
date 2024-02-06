package stacks;

import java.util.Scanner;

public class Stack {
    static int MAX_SIZE = 5;
    static int top = -1;

    static void push(int[] stack, int data) {
        top++;
        if (top == MAX_SIZE) {
            top--;
            System.out.println("Overflow!");
            return;
        }
        stack[top] = data;
    }

    static int pop(int[] stack) {
        if (top <= -1) {
            return -1;
        }
        int poppedElement = stack[top];
        top--;
        return poppedElement;
    }

    static void printStack(int[] stack) {
        if (top == -1) {
            System.out.println("Stack Empty!");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stack = new int[MAX_SIZE];
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
                    push(stack, sc.nextInt());
                }
                case 2 -> {
                    int poppedElement = pop(stack);
                    if (poppedElement == -1) {
                        System.out.println("Underflow!");
                    }
                    else {
                        System.out.println("The popped element is: " + poppedElement);
                    }
                }
                case 3 -> printStack(stack);
                case 4 -> System.out.println("Exiting!");
                default -> System.out.println("Invalid!");
            }
        } while (choice != 4);
    }
}
