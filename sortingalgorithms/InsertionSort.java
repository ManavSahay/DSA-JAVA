package sortingalgorithms;

import printarray.PrintArray;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        int key, i, j;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        insertionSort(arr);
        PrintArray.printArray(arr);
    }
}
