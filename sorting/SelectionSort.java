import java.util.*;

public class SelectionSort {
    public static void swap(int[] arr, int p, int q) {
        if (p == q) { return; }
        int t = arr[p];
        arr[p] = arr[q];
        arr[q] = t;
    }

    public static void printArr(int[] arr) {
        for (int i: arr)
            System.out.println(i);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int n = arr.length, pos;
        for (int i = 0; i < n - 1; i++) {
            pos = i;
            for (int j = i + 1; j < n; j++) {
                pos = (arr[j] < arr[pos]) ? j: pos;
            }
            swap(arr, i, pos);
        }
        printArr(arr);
    }
}