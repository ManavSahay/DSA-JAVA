package sortingalgorithms;

import printarray.PrintArray;

public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotInd = partition(arr, low, high);
            quickSort(arr, low, pivotInd - 1);
            quickSort(arr, pivotInd + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        quickSort(arr, 0, arr.length - 1);
        PrintArray.printArray(arr);
    }
}
