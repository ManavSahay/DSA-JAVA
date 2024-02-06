package sortingalgorithms;

import printarray.PrintArray;

public class HeapSort {
    static void heapSort(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        int largest = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        heapSort(arr);
        PrintArray.printArray(arr);
    }
}
