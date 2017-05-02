import java.util.*;

public class MaxSubArray {

    private static class Triplet {
        int lpos;
        int rpos;
        int max;
    }

    public static Triplet findMaxAcrossMid(int[] arr, int lo, int mid, int hi) {
        int lPos = mid, rPos = mid;
        int lMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= lo; i--) {
            sum += arr[i];
            if (sum > lMax) {
                lMax = sum;
                lPos = i;
            }
        }
        int rMax = Integer.MIN_VALUE;
        int rpos;
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += arr[j];
            if (sum > rMax) {
                rMax = sum;
                rPos = j;
            }
        }
        Triplet t = new Triplet();
        t.lpos = lPos;
        t.rpos = rPos;
        t.max = lMax + rMax;
        return t;
    }

    public static Triplet findMaxSubArr (int[] arr, int l, int r) {
        if (l == r) {
            Triplet t = new Triplet();
            t.lpos = l;
            t.rpos = r;
            t.max = arr[l];
            return t;
        }

        int mid = l + (r - l) / 2;

        Triplet left = findMaxSubArr(arr, l, mid);
        Triplet right = findMaxSubArr(arr, mid + 1, r);
        Triplet cross = findMaxAcrossMid(arr, l, mid, r);
        if (left.max > right.max && left.max > cross.max)
            return left;
        else if (right.max > left.max && right.max > cross.max)
            return right;
        else
            return cross;
    }

    public static int[] getDeltas (int[] arr) {
        int l = arr.length;
        int[] deltas = new int[l - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            deltas[i] = arr[i + 1] - arr[i];
        }
        return deltas;
    }

    public static void main (String[] args) {
        int[] arr = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        // int[] arr = {100, 113, 110};
        int[] deltas = getDeltas(arr);
        System.out.println(findMaxSubArr(deltas, 0, deltas.length - 1).max);
    }
}
