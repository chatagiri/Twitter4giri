import twitter4j.*;
import java.util.*;
import java.text.*;

class TwitterStatusListener implements StatusListener {

    private long userId;
    private long statusId;
    private Boolean collageFlag = false;
    private String tweet;
    private String userName; // profile name of tweeted user
    private String screenName; // @-
    private String changeName;
    private String nowDate;
    private Twitter twitter; // twitter instance
    private User user; // setting user info from twitter4j.properties
    private TwitterFunction twitterFunction = new TwitterFunction();

    public void onStatus(Status status) {

        try {
            userId = status.getUser().getId();
            statusId = status.getId();
            tweet = status.getText();
            userName = status.getUser().getName();
            screenName = status.getUser().getScreenName();  // @-
            nowDate = new SimpleDateFormat("【yyyy/MM/dd HH:mm:ss】").format(new Date());

                /* show timeline
                /  - userName(@screenName) [nowDate]
                /  - tweet contents */
            System.out.println("-----------------------------------------------------");
            System.out.println(userName+ "(@" + screenName +") " + nowDate + "\n" + tweet);

            if (tweet.contains("@chatagiriii") == true && tweet.endsWith("@chatagiriii")) {
                // cutting before "@chatagiriii"
                changeName = tweet.substring(0, tweet.indexOf("@chatagiriii"));
                twitterFunction.updateProfileName(changeName,screenName,nowDate);
            }

            if((tweet.contains("片桐！？") || tweet.contains("片桐!?"))) {
               twitterFunction.replyChatagiriCollage(userName, screenName, statusId);
            }

        } catch (Exception e) {
            System.out.println("an Exception");
        }
    }

    public void onDeletionNotice(StatusDeletionNotice sdn) {
    }

    public void onTrackLimitationNotice(int i) {
    }

    public void onScrubGeo(long lat, long lng) {
    }

    public void onException(Exception e) {

    }

    @Override
    public void onStallWarning(StallWarning arg0) {

    }
    // do tweet @tweet wanna tweet contents.
}