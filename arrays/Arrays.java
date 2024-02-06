package arrays;

public class Arrays {
    static int MAX_SIZE = 10;

    static int length = MAX_SIZE;

    static void insertion(int[] arr, int position, int data) {
        if (length >= MAX_SIZE) {
            System.out.println("Array full!");
            return;
        }
        for (int i = length - 1; i >= position; i--) {
            arr[i + 1] = arr[i];
        }
        arr[position] = data;
        length++;
    }

    static int deletion(int[] arr, int position) {
        if (length < 0) {
            return -1;
        }
        int deletedElement = arr[position];
        for (int i = position; i < length; i++) {
            arr[i] = arr[i + 1];
        }
        length--;
        return deletedElement;
    }

    static void traversal(int[] arr) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = new int[MAX_SIZE];
        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
        }
        length = 5;

        traversal(arr);
        insertion(arr, 2, 10);
        traversal(arr);

        int deletedElement = deletion(arr, 2);
        if (deletedElement == -1) {
            System.out.println("Array empty");
        }
        else {
            System.out.println("Deleted element: " + deletedElement);
        }

        traversal(arr);
    }
}
