package sortingalgorithms;

import printarray.PrintArray;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        int i, j, minIndex;
        for (i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        selectionSort(arr);
        PrintArray.printArray(arr);
    }
}
