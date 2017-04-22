import java.util.*;

public class CoinChange {

    public static int count(int[] S, int N, int m) {
        if (N == 0)
            return 1;
        if (N < 0)
            return 0;
        if (m < 0 && N >= 1)
            return 0;
        return count(S, N, m - 1) + count(S, N - S[m], m);
    }

    public static void main(String[] args) {
        int[] S = {2, 5, 3, 6};
        int N = 10;
        System.out.println(count(S, N, S.length - 1));
    }
}