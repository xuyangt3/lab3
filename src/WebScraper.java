import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner = null;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param contents contents to count words from
     * @return the number of words
     */
    public static int wordCount(String contents) {
        Character.isWhitespace(' ');
        String[] words = contents.split("\\s+");
//        for (String i : words) {
//            System.out.println("||:" + i + ":||");
//        }
        return words.length;
    }

    public static void main(String[] args) {
        System.out.println("input \\exit to end the program");
        Scanner scan = new Scanner(System.in);
        String token;
        while (!(token = scan.nextLine()).equals("exit")) {
            System.out.println(wordCount(token));
        }
    }
}