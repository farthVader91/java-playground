public class InversionCount {
    private static int nc = 0;

    private static int mergeSort(Integer[] arr) {
        int n = arr.length;
        Integer[] aux = new Integer[n];
        int result = _mergeSort(arr, aux, 0, n - 1);
        System.out.println("Array length: " + n);
        System.out.println("Number of comparisons: " + nc);
        return result;
    }

    private static int _mergeSort(Integer[] arr, Integer[] aux, int left, int right) {
        int mid, invCount = 0;
        if (right > left) {
            mid = (left + right) / 2;

            invCount = _mergeSort(arr, aux, left, mid);
            invCount += _mergeSort(arr, aux, mid + 1, right);

            invCount += merge(arr, aux, left, mid + 1, right);
        }

        return invCount;
    }

    private static int merge(Integer[] arr, Integer[] aux, int left, int mid, int right) {
        int i, j, k;
        int invCount = 0;

        i = left;
        j = mid;
        k = left;
        while((i <= mid - 1) && (j <= right)) {
            nc++;
            if(arr[i] <= arr[j])
                aux[k++] = arr[i++];
            else {
                aux[k++] = arr[j++];
                invCount += (mid - i);
            }
        }
        while(j <= right)
            aux[k++] = arr[j++];
        while(i <= (mid - 1))
            aux[k++] = arr[i++];
        for(i = left; i <= right; i++)
            arr[i] = aux[i];

        return invCount;
    }

    private static int bruteForce(Integer[] arr) {
        int invCount = 0;
        int numCompares = 0;
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                numCompares++;
                if(arr[i] > arr[j]) invCount++;
            }
        }
        System.out.println("Array length: " + n);
        System.out.println("Number of comparisons: " + numCompares);
        return invCount;
    }

    public static void main(String[] args) {
        Integer[] arr = {40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 20, 19, 18, 10, 8, 9, 2, 6, 1, 0};
        System.out.println("Inversion count(brute force): " + bruteForce(arr));
        System.out.println("Inversion count(enhanced merge sort): " + mergeSort(arr));
    }
}
