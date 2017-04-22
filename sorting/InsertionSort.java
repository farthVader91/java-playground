import java.util.*;

public class InsertionSort {
	public static void sort(Comparable[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			Comparable c = arr[i];
			int j = i - 1;
			while(j >= 0 && less(c, arr[j])) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[++j] = c;
		}
	}

	public static boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}

	public static void show(Comparable[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args) {
		Integer[] a = {5, 4, 3, 2, 1};
		sort(a);
		show(a);
	}
	
}