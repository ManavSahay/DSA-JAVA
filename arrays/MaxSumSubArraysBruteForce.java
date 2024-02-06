package arrays;

public class MaxSumSubArraysBruteForce {
    public static void printSubArraysMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Sum = " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 6, -1, 3};
        printSubArraysMaxSum(arr);
    }
}
