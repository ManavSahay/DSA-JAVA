package searchingalgorithms;

import printarray.PrintArray;
import sortingalgorithms.BubbleSort;

public class BinarySearchRecursive {
    static int binarySearch(int[] arr, int key, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] > key) {
                return binarySearch(arr, key, low, mid - 1);
            }
            else {
                return binarySearch(arr, key, mid + 1, high);
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

        int position = binarySearch(arr, key, 0, arr.length - 1);
        if (position == -1) {
            System.out.println("Element not found!");
        }
        else {
            System.out.println("Element " + key + " found at position " + position);
        }
    }
}
