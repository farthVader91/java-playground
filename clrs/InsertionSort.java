import java.util.*;

public class InsertionSort {

    public static void ascSort (int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                } else break;
            }
        }
    }

    public static void descSort (int[] arr) {
        int len = arr.length, j;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            j = i - 1;
            while ((j >= 0) && (key > arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArr (int[] arr) {
        for (int i: arr) System.out.println(i);
    }

    public static void main (String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 0};
        ascSort(arr);
        printArr(arr);
        descSort(arr);
        printArr(arr);
    }
}