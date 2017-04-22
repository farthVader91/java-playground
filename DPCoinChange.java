import java.util.*;

public class DPCoinChange {

    public static long count(int[] coins, int m, int n) {
        int[] tables = new int[n + 1];
        Arrays.fill(tables, 0);
        tables[0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++)
                tables[j] += tables[j - coins[i]];
        }
        return tables[n];
    }

    public static void main(String[] args) {
        int[] S = {2, 5, 3, 6};
        int N = 10;
        System.out.println(count(S, S.length, N));
    }
}