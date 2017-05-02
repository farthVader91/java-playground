import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class InputOutput {
    public static void main (String[] args) throws IOException {
        char c;
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        do {
            c = (char) obj.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
