package arrays;

public class MaxSubArrayKadanes {
    public static void kadanes(int[] numbers) {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            curr_sum += numbers[i];
            if (curr_sum < 0) {
                curr_sum = 0;
            }
            max_sum = Math.max(curr_sum, max_sum);
        }

        System.out.println("Max Sum = " + max_sum);
    }
    public static void main(String[] args) {
        int[] numbers = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes(numbers);
    }
}
