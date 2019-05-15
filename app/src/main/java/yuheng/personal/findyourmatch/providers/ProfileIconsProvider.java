package yuheng.personal.findyourmatch.providers;

import android.graphics.Bitmap;

public class ProfileIconsProvider extends AbstractImageProvider {
    private static ProfileIconsProvider instance;
    private static String rootUrl = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/profile-icons/";

    public static ProfileIconsProvider getInstance(){
        if(instance == null)
            instance = new ProfileIconsProvider();
        return instance;
    }

    @Override
    public Bitmap getImage(int imageNum) {
        String url = rootUrl + "" + imageNum + ".jpg";
        return getImageFromUrl(url);
    }
}
