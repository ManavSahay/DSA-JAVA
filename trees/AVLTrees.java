package trees;

public class AVLTrees {
    static class Node {
        int data, height;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;

        // Rotate
        y.left = x;
        x.right = temp;

        // Update Heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static int getBalance(Node root) {
            if (root == null) {
                return 0;
            }
            return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get Balance Factor
        int bf = getBalance(root);

        // Left-Left Case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right-Right Case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left-Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right-Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
