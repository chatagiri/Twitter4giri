import twitter4j.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;

class TwitterFunction {

    private TwitterOAuthConf oAuthConf = new TwitterOAuthConf();

    private Twitter twitter = oAuthConf.getTwitter();
    private long collageId;
    private boolean collageFlag = false;

    void updateStatus(String tweet) throws Exception {
        twitter.updateStatus(tweet);
        System.out.println("StatusUpdate successfully.");
    }

    void updateProfileName(String changeName, String screenName, String nowDate) throws Exception {
        System.out.println("NextName: " + changeName);
        String url = "http://circle.iwate-pu.jp/~suibu/";
        String location = "";
        String description  = "";

        twitter.updateProfile(changeName, url, location, description);
        System.out.println("ProfileUpdate successfully");
        this.updateStatus("@" + screenName + " WTF MY NAME HAS CHANGED TO " + changeName + " " + nowDate);
    }

    void replyChatagiriCollage(String userName, String screenName, long statusId) throws Exception {

        BufferedImage image = null;
        String inPath = "assets/katagiri.jpg";
        String outPath = "assets/out.jpg";
        int userNameLen = userName.length();

        /* 画像にUserNameを挿入する */
        image = ImageIO.read(new File(inPath));
        Graphics graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("MS明朝", Font.PLAIN, 10));

        for (int i = 0; i < userNameLen; i++) {
            graphics.drawString(userName.substring(i, i + 1), 34, 40 + i * 11);
            if (i == 5) break;
        }

        ImageIO.write(image, "jpg", new File(outPath));

        if(collageFlag == true)
            twitter.destroyStatus(collageId);

        StatusUpdate su = new StatusUpdate("@" + screenName).media(new File(outPath));
        collageId = twitter.updateStatus(su.inReplyToStatusId(statusId)).getId();
        collageFlag = true;
    }

}
