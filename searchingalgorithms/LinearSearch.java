package searchingalgorithms;

public class LinearSearch {
    static int linearSearch(int[] arr, int key) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                position = i;
                break;
            }
        }
        return position;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int key = 2;

        int position = linearSearch(arr, key);
        if (position == -1) {
            System.out.println("Element " + key + " not found!");
        }
        else {
            System.out.println("Element " + key + " found at position " + position);
        }
    }
}
