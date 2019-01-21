/**
 * Created by Redmal on 1/21/2019.
 * Goal is to retrieve the 5 most recent tweets
 * by President Donald Trump
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DTtwitterScrape {

    public static void main(String[] args) throws IOException {
        int numOfTweet = 0;

        String twitterUrl = "https://twitter.com/realDonaldTrump";

        Document twitterDoc = Jsoup.connect(twitterUrl).get();

        Elements tweets = twitterDoc.getElementsByClass("TweetTextSize");

        System.out.println("-----Most recent 5 tweets by President Trump-----\n");

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
