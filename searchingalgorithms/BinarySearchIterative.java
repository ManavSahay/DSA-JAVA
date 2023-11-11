package searchingalgorithms;

import sortingalgorithms.BubbleSort;
import printarray.PrintArray;

public class BinarySearchIterative {
    static int binarySearch(int[] arr, int key) {
        int position = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] > key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int key = 2;

        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted Array: ");
        PrintArray.printArray(arr);
        System.out.println();

        int position = binarySearch(arr, key);
        if (position == -1) {
            System.out.println("Element not found!");
        }
        else {
            System.out.println("Element " + key + " found at position " + position);
        }
    }
}
