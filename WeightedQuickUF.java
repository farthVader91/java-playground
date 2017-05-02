import java.util.*;


public class WeightedQuickUF {
    private int[] arr;
    private int[] parent;
    private int[] size;

    public WeightedQuickUF(int n) {
        arr = new int[n];
        parent = new int[n];
        size = new int[n];
        // Initialize all internal values
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int n) {
        while(parent[n] != n)
            n = parent[n];
        return n;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        // merge one node with the larger node
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] = size[rootP] + size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] = size[rootP] + size[rootQ];
        }
    }

    public static void main(String[] args) {
        int[][] ip = {{1, 1, 0, 0, 0},
                      {1, 1, 0, 0, 0},
                      {0, 0, 0, 0, 0},
                      {0, 0, 0, 1, 1}};
        int n = ip.length;
        int m = ip[0].length;
        WeightedQuickUF wqu = new WeightedQuickUF(n*m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ip[i][j] == 0)
                    continue;
                if ((i+1<n) && (ip[i+1][j] == 1))
                    wqu.union(i*m+j, (i+1)*m+j);
                if ((i-1>=0) && (ip[i-1][j] == 1))
                    wqu.union(i*m+j, (i-1)*m+j);
                if ((j+1<m) && (ip[i][j+1] == 1))
                    wqu.union(i*m+j, i*m+j+1);
                if ((j-1>=0) && (ip[i][j-1] == 1))
                    wqu.union(i*m+j, i*m+j-1);
                if ((i+1<n) && (j+1<m) && (ip[i+1][j+1] == 1))
                    wqu.union(i*m+j, (i+1)*m+j+1);
                if ((i+1<n) && (j-1>=0) && (ip[i+1][j-1] == 1))
                    wqu.union(i*m+j, (i+1)*m+j-1);
                if ((i-1>=0) && (j+1<m) && (ip[i-1][j+1] == 1))
                    wqu.union(i*m+j, (i-1)*m+j+1);
                if ((i-1>=0) && (j-1>=0) && (ip[i-1][j-1] == 1))
                    wqu.union(i*m+j, (i-1)*m+j-1);
            }
        }
        int count = 0;
        int[] freq = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ip[i][j] != 1)
                    continue;
                int v = i * m + j;
                int root = wqu.find(v);
                if (freq[root] == 0)
                    count++;
                freq[root]++;
            }
        }
        System.out.println(count);
    }

}
