package trees;

import java.util.Scanner;

public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insertBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertBST(root.left, data);
        }
        else {
            root.right = insertBST(root.right, data);
        }
        return root;
    }

    public boolean searchTree(Node root, int key) {
        if (root.data == key) {
            return true;
        }
        else if (root == null) {
            return false;
        }
        else if (root.data < key) {
            return searchTree(root.right, key);
        }
        else {
            return searchTree(root.left, key);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        boolean found;

        System.out.println("Enter number of numbers: ");
        int size = sc.nextInt();

        Node root = null;
        System.out.println("Enter first number: ");
        root = bst.insertBST(root, sc.nextInt());

        for (int i = 0; i < size - 1; i++) {
            System.out.println("Enter data: ");
            int data = sc.nextInt();
            bst.insertBST(root, data);
        }

        System.out.println("InOrder traversal");
        bst.inOrder(root);
        System.out.println();

        System.out.println("Enter value to be searched: ");
        found = bst.searchTree(root, sc.nextInt());
        if (found) {
            System.out.println("Element found");
        }
        else {
            System.out.println("Element not found");
        }
    }
}
