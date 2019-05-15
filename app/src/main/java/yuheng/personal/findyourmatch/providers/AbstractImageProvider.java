package yuheng.personal.findyourmatch.providers;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public abstract class AbstractImageProvider{

  protected static HashMap<Integer,String> updateMap(String url) {
      try {
        System.setProperty("http.agent", "Chrome");
        URL u = new URL(url);
        Scanner scanner = new Scanner(u.openStream());

        HashMap<Integer, String> Map = new HashMap<Integer, String>();
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          if (line.length() >= 11 && line.substring(0, 10).equals("<tr><td><a")) {
            try {
              int num = Integer.parseInt(line.substring(17, line.indexOf("_")));
              String string = line.substring(17, line.indexOf(".") + 4);
              Map.put(num, string);
              System.out.println(num + "," + string);
            } catch (Exception e) {
              //handle this
            }
          }
        }
        return Map;
      } catch (Exception e) {
        return null;
      }
  }

  protected Bitmap getImageFromUrl(String imageUrl)  {
    try {
      URL url = new URL(imageUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput(true);
      connection.connect();
      InputStream input = connection.getInputStream();
      Bitmap myBitmap = BitmapFactory.decodeStream(input);
      return myBitmap;
    } catch (IOException e) {
      // Log exception
      return null;
    }
  }

  public abstract Bitmap getImage(int imageNum);
}
