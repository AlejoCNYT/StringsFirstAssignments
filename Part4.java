import edu.duke.URLResource;

/**
 * Finds and prints each URL on a web page that is a link to youtube.com.
 * Reads the page word by word and extracts URLs in the format "http:[stuff]youtube.com[stuff]".
 */
public class Part4 
{

    private static final String PAGE_URL = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
    private static final String YOUTUBE_MARKER = "youtube.com";

    /**
     * Finds the opening double quote before the given position (searching backward).
     *
     * @param word the string to search in
     * @param endPos the last position to look (exclusive)
     * @return the index of the double quote, or -1 if not found
     */
    private int findOpeningQuote(String word, int endPos)
    {
        return word.lastIndexOf("\"", endPos);
    }

    /**
     * Finds the closing double quote after the given position.
     *
     * @param word the string to search in
     * @param startPos the position to start looking from
     * @return the index of the double quote, or -1 if not found
     */
    private int findClosingQuote(String word, int startPos) 
    {
        return word.indexOf("\"", startPos);
    }

    /**
     * Extracts the YouTube URL from a word that contains "youtube.com".
     * Uses the original string to preserve case (YouTube links are case sensitive).
     *
     * @param word the word (or token) that contains youtube.com
     * @return the URL between the surrounding double quotes, or null if not valid
     */
    private String extractYouTubeUrl(String word) 
    {
        String wordLower = word.toLowerCase();
        int youtubeIndex = wordLower.indexOf(YOUTUBE_MARKER);
        if (youtubeIndex == -1) 
        {
            return null;
        }

        // Find the opening quote (to the left of youtube.com)
        int quoteStart = findOpeningQuote(word, youtubeIndex);
        if (quoteStart == -1) 
        {
            return null;
        }

        // Find the closing quote (to the right of youtube.com)
        int quoteEnd = findClosingQuote(word, youtubeIndex + YOUTUBE_MARKER.length());
        if (quoteEnd == -1) 
        {
            return null;
        }

        // URL is between the quotes (exclude the quote characters)
        return word.substring(quoteStart + 1, quoteEnd);
    }

    /**
     * Reads the web page word by word and prints each URL that is a link to youtube.com.
     */
    public void printYouTubeLinks() 
    {
        URLResource resource = new URLResource(PAGE_URL);

        for (String word : resource.words()) 
        {
            String url = extractYouTubeUrl(word);
            if (url != null)
            {
                System.out.println(url);
            }
        }
    }

    public static void main(String[] args) 
    {
        Part4 part4 = new Part4();
        part4.printYouTubeLinks();
    }
}
