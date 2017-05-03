import java.util.*;

public class MaxSubArray {
    public static double maxSubArr (int[] arr) {
        double max = 0;
        int l = arr.length;
        for (int i = 0; i < l - 1; i ++) {
            for (int j = i + 1; j < l; j++) {
                // Array to calculate delta across j - i days
                double sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k + 1] - arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main (String[] args) {
        int[] arr = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        System.out.println(maxSubArr(arr));
    }
}