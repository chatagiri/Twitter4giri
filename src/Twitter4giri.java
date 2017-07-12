import twitter4j.*;

public class Twitter4giri {

    public static void main(String[] args) throws Exception {

        TwitterStream twStream = new TwitterStreamFactory().getInstance();
        twStream.addListener(new TwitterStatusListener());
        twStream.user();
    }
}


