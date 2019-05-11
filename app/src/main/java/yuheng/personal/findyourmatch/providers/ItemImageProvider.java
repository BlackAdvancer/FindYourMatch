package yuheng.personal.findyourmatch.providers;

import android.graphics.Bitmap;
import java.util.HashMap;

public class ItemImageProvider extends AbstractImageProvider {
  private HashMap<Integer,String> hashMap;
  private static ItemImageProvider instance;
  private static String rootUrl = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/data/items/icons2d/";

  private ItemImageProvider(String rootUrl){
    hashMap = updateMap(Update(rootUrl));
  }

  public static ItemImageProvider getInstance(){
    if(instance == null)
      instance = new ItemImageProvider(rootUrl);
    return instance;
  }

  @Override
  public Bitmap getImage(int imageNum) {
    String url = rootUrl + hashMap.get(imageNum);
    return getImageFromUrl(url,imageNum);
  }
}
