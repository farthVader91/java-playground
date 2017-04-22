import java.util.*;

public class DavisStaircase {

    public static long noOfWays(int height) {
        long ways = 0;
        if (height == 0) return 1;
        if (height < 0) return 0;
        return (noOfWays(height - 1) + noOfWays(height - 2) + noOfWays(height - 3));
    }

    public static void main (String[] args) {
        System.out.println(noOfWays(7));
    }
}