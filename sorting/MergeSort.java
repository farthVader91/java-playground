import java.util.*;

public class MergeSort {

    public static int[] copy(int[] arr, int l, int r) {
        int n = r - l + 1;
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++)
            tmp[i] = arr[l + i];
        return tmp;
    }

    public static long merge(int[] arr, int l, int m, int r) {
        long inversions = 0;
        int[] aux = copy(arr, l, r);
        int i = 0, j = m - l + 1, k = l;
        while(i <= m - l && j <= r - l) {
            if (aux[i] <= aux[j])
                arr[k++] = aux[i++];
            else {
                arr[k++] = aux[j++];
                inversions += (m - l) - i + 1;
            }
        }
        while (i <= m - l)
            arr[k++] = aux[i++];
        while (j <= r - l)
            arr[k++] = aux[j++];
        return inversions;
    }


    public static long sort(int[] arr, int l, int r) {
        long inversions = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            inversions = sort(arr, l, mid) + sort(arr, mid + 1, r) + merge(arr, l, mid, r);
        }
        return inversions;
    }

    public static long sort(int[] arr) {
        int n = arr.length;
        return sort(arr, 0, n - 1);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 13, 2, 5, 1, 10};
        System.out.println(sort(arr));
        // printArray(arr);
    }
}