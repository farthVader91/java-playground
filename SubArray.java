import java.util.*;

public class SubArray {
    public static ArrayList<ArrayList<Character>> getSubArrays(char[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                ArrayList<Character> t = new ArrayList<Character>();
                for(int k = i; k <= j; k++)
                    t.add(arr[k]);
                res.add(t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        ArrayList<ArrayList<Character>> res = getSubArrays(arr);
        for(ArrayList<Character> a: res)
            System.out.println(a);
    }
}
