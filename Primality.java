import java.util.*;

public class Primality {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(0));
    }
}