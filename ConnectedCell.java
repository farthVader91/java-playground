import java.util.*;

public class ConnectedCell {
    public static boolean isInvalidPos(int r, int c, int n, int m) {
        return (r < 0 || r >= n || c < 0 || c >= m);
    }

    public static long getRegionSize(int[][] grid, int r, int c, boolean[][] visited) {
        long size = 0;
        int n = grid.length, m = grid[0].length;
        if (isInvalidPos(r, c, n, m) || grid[r][c] != 1 || visited[r][c])
            return size;
        // Mark current position as visited
        visited[r][c] = true;
        return (1 + getRegionSize(grid, r - 1, c - 1, visited)
            + getRegionSize(grid, r - 1, c, visited) + getRegionSize(grid, r - 1, c + 1, visited)
            + getRegionSize(grid, r, c - 1, visited) + getRegionSize(grid, r, c + 1, visited)
            + getRegionSize(grid, r + 1, c - 1, visited) + getRegionSize(grid, r + 1, c , visited)
            + getRegionSize(grid, r + 1, c + 1, visited));
    }

    public static long largestRegion(int[][] grid) {
        long count = 0;
        int n = grid.length;
        if (n == 0) return count;
        int m = grid[0].length;
        if (m == 0) return count;
        // Initialize visited array
        boolean[][] visited = new boolean[n][m];
        // Walk over the array, identifying largest count
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = Math.max(count, getRegionSize(grid, i, j, visited));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][]grid = { {1, 1, 0, 0},
                        {0, 1, 1, 0},
                        {0, 0, 1, 0},
                        {1, 1, 1, 0} };
        System.out.println(largestRegion(grid));
    }

}