package yuheng.personal.findyourmatch.providers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public abstract class AbstractImageProvider {

  public static File Update(String urls){
    File file = new File("out.txt");
    try {
      System.setProperty("http.agent", "Chrome");
      URL url = new URL(urls);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
      BufferedInputStream input = new BufferedInputStream(urlConnection.getInputStream());
      FileOutputStream foutput = new FileOutputStream(file);
      BufferedOutputStream boutput = new BufferedOutputStream(foutput, 1024);
      byte[] buffer = new byte[1024];
      int read = 0;
      while ((read = input.read(buffer, 0, 1024)) >= 0) {
        boutput.write(buffer, 0, read);
      }
      boutput.close();
      input.close();
      System.out.println("Update Sucessful");
    }catch (IOException e){
      System.err.println("IOException");
    }

    return file;
  }

  public static HashMap<Integer,String> updateMap(File file){
    try {
      Scanner scanner = new Scanner(file);
      HashMap<Integer,String> Map = new HashMap<Integer,String>();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if(line.length()>=11 && line.substring(0,10).equals("<tr><td><a")){
          try{
            int num = Integer.parseInt(line.substring(17,line.indexOf("_")));
            String string = line.substring(17, line.indexOf(".")+4);
            System.out.println("Key: "+num+"Url: "+string);
            Map.put(num,string);
          }catch(Exception e){
            //handle this
          }
        }
      }
      return Map;
    } catch(FileNotFoundException e) {
      return null;
    }
  }

  public Bitmap getImageFromUrl(String imageUrl, int num)  {
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
