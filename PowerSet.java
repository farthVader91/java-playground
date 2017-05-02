import java.util.*;

public class PowerSet {
    public static ArrayList<ArrayList<Character>> powerset(char[] arr) {
        ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
        int len = arr.length;
        double N = Math.pow(2, len);
        for(int counter = 0; counter < N; counter++) {
            ArrayList<Character> t = new ArrayList<Character>();
            for(int j = 0; j < len; j++) {
                if ((counter & (1 << j)) > 0)
                    t.add(arr[j]);
            }
            res.add(t);
        }
        return res;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        ArrayList<ArrayList<Character>> result = powerset(arr);
        for(ArrayList<Character> a: result)
            System.out.println(a);
    }
}
