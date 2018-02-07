import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public class WebScraper {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] args) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int wordcountofking = 0;
        Pattern a = Pattern.compile("king");
        Matcher b = a.matcher(text);
        while (b.find()) {
            wordcountofking++;
        }
        System.out.println(wordcountofking);
    }
}
