import twitter4j.*;
import twitter4j.conf.*;

/**
 * Created by chata on 2017/07/12.
 */
class TwitterOAuthConf {

    private ConfigurationBuilder cb = new ConfigurationBuilder() ;
    private TwitterFactory twitterFactory;
    private Twitter twitter;
    private TwitterStream stream;
    private TwitterStreamFactory streamFactory;

    TwitterOAuthConf(){
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");
    }

    TwitterStream getStream(){
        streamFactory = new TwitterStreamFactory(cb.build());
        stream = streamFactory.getInstance();
        return stream;
    }

    Twitter getTwitter(){
        twitterFactory = new TwitterFactory(cb.build());
        twitter = twitterFactory.getInstance();
        return twitter;
    }

}
