import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {
        String url = "https://www.hackerearth.com/confirm_email/adfnsm23jknj23765r2i";
        String pattern = "https://www.hackerearth.com/confirm_email/(\\w+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(url);
        if (m.find()) {
            System.out.println("Found value: " + m.group(1) );
        } else System.out.println("NO MATCH!");
    }
}
