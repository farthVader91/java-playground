import java.util.*;

public class XORGAME {
    public static int getSubArrayXor(int[] arr) {
        int N = arr.length;
        int x = 0;
        if (N % 2 > 0) {
            for(int i = 0; i < N; i++) {
                if(i % 2 == 0) x^= arr[i];
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6};
        System.out.println(getSubArrayXor(arr));
    }
}
