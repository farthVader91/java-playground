import java.util.*;

public class DavisStaircase {
    public static HashMap<Integer, Integer> ways = new HashMap<Integer, Integer>();

    public static int noOfWays(int height) {
        Integer w = ways.get(height);
        if (w != null)
            return w;
        if (height == 0) return 1;
        if (height < 0) return 0;
        w = (noOfWays(height - 1) + noOfWays(height - 2) + noOfWays(height - 3));
        ways.put(height, w);
        return w;
    }

    public static void main (String[] args) {
        System.out.println(noOfWays(7));
    }
}