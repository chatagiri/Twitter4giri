import twitter4j.*;

public class Twitter4giri {

    public static void main(String[] args) throws Exception {
        TwitterOAuthConf toc = new TwitterOAuthConf();
        TwitterStream twStream = toc.getStream();
        twStream.addListener(new TwitterStatusListener());
        twStream.user();
    }
}


