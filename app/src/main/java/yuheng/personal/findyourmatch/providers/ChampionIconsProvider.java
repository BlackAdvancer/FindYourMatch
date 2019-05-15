package yuheng.personal.findyourmatch.providers;

import android.graphics.Bitmap;

import java.util.HashMap;

public class ChampionIconsProvider extends AbstractImageProvider {

    private static ChampionIconsProvider instance;
    private static String rootUrl = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/";


    public static ChampionIconsProvider getInstance(){
        if(instance == null)
            instance = new ChampionIconsProvider();
        return instance;
    }

    @Override
    public Bitmap getImage(int imageNum) {
        String url = rootUrl + "" + imageNum + ".png";
        return getImageFromUrl(url);
    }
}
