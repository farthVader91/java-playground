import java.util.*;

public class ShellSort {
	public static void sort(Comparable[] arr) {
		int n = arr.length;

		int k = 1;
		while (k < n/3) k = k * 3 + 1;

		while (k >= 1) {
			for (int i = k; i < n; i++) {
				Comparable c = arr[i];
				int j = i - k;
				while(j >= 0 && less(c, arr[j])) {
					arr[j + k] = arr[j];
					j = j - k;
				}
				arr[j + k] = c;
			}	
			k = k/3;
		}
	}

	public static boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}

	public static void show(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.println(a[i]);
	}

	public static void main(String[] args) {
		Integer[] arr = {5, 4, 3, 2, 11, 10, 9, 8, 7, 6, 1};
		sort(arr);
		show(arr);
	}
}