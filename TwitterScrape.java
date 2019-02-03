/**
 * Created by Redmal on 2/2/2019.
 * Goal is to retrieve the 5 most recent tweets
 * a person's Twitter account specified by the user.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;


public class TwitterScrape {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numOfTweet = 0;

        System.out.print("Enter a person to get their Twitter feed: ");
        String userResponse = scanner.nextLine();

        String twitterUrl = "http://www.google.com/search?hl=en&btnI=1&q=" + userResponse + " twitter";

        Document twitterDoc = Jsoup.connect(twitterUrl).get();

        Elements tweets = twitterDoc.getElementsByClass("TweetTextSize");

        System.out.println("-----Most recent 5 tweets by " + userResponse +"-----\n");

        //filter headers that contain getUserTopic
        numOfTweet = 0;
        GrabTweetsLoop: for (Element tweet : tweets){
            System.out.println((numOfTweet + 1) + ": " + tweet.text());

            numOfTweet += 1;
            if (numOfTweet == 5){
                break GrabTweetsLoop;
            }
        }
    }
}
