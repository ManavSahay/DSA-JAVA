package trees;

import java.util.Scanner;

public class BinaryTree {
    Scanner sc = new Scanner(System.in);
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

    public Node takeInput() {
        System.out.println("Enter a number (-1 to enter null)");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        root.left = takeInput();
        root.right = takeInput();
        return root;
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.takeInput();
        tree.preOrder(root);
        tree.inOrder(root);
        tree.postOrder(root);
    }
}
