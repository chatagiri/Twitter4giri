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
        cb.setOAuthConsumerKey("QxKBOV8ZWi2lHl5wWCqiuMV7X");
        cb.setOAuthConsumerSecret("hys7csFC5int54KiQPbnynFojsD0xDjxWunnTc2latzeE3AFMP");
        cb.setOAuthAccessToken("2476331220-pI9zPxpoSizVroXk3L1cdLx1xsFKzWF5ixstvBx");
        cb.setOAuthAccessTokenSecret("4wvnsorpE82z0QAfz01a0bI9JDKcktaRpd6ksy9rvxBql");
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
