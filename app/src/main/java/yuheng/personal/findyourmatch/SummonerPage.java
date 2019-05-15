package yuheng.personal.findyourmatch;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import yuheng.personal.findyourmatch.model.MatchInfo;
import yuheng.personal.findyourmatch.model.MatchManager;
import yuheng.personal.findyourmatch.model.Summoner;
import yuheng.personal.findyourmatch.providers.ItemImageProvider;

public class SummonerPage extends AppCompatActivity {
  Summoner summoner;
  MatchManager matchManager = MatchManager.getInstance();
  ItemImageProvider itemImageProvider;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_summoner_page);

  }

  @Override
  protected void onResume() {
    super.onResume();
    //displaySummonerInfo();
    //new findMatchInfo().execute();
    new displayImage().execute(59);

  }

  public class findMatchInfo extends AsyncTask<String,Integer,MatchInfo[]> {

    @Override
    protected MatchInfo[] doInBackground(String... params) {
      return matchManager.getMatches(summoner.getSummonerName(),summoner.getMatchesList());
    }

    @Override
    protected void onPostExecute(MatchInfo[] matchInfos) {
      super.onPostExecute(matchInfos);
      displayMatchInfo(matchInfos);
    }
  }

  public class displayImage extends AsyncTask<Integer,Integer, Bitmap> {
    @Override
    protected Bitmap doInBackground(Integer... parmas) {
      itemImageProvider = ItemImageProvider.getInstance();
      return itemImageProvider.getImage(parmas[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
      super.onPostExecute(bitmap);
      ImageView imageView = findViewById(R.id.profileIcon);
      imageView.setImageBitmap(bitmap);
    }
  }

  private void displaySummonerInfo(){
    summoner = getIntent().getParcelableExtra("Summoner");
    System.out.println(summoner.getSummonerName());
    TextView textView = findViewById(R.id.textView);
    TextView textView2 = findViewById(R.id.textView2);
    textView.setText(summoner.getSummonerName());
    textView2.setText(String.format("%s",summoner.getSummonerLevel()));
  }

  private void displayMatchInfo(MatchInfo[] matchInfos){
    LinearLayout linearLayout = findViewById(R.id.linearLayout);
    LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (matchInfos.length == 0){
      //TODO: display cannot find recent match.
    }else{
      for (MatchInfo m:matchInfos) {
        System.out.println(m.toString());
        View v = vi.inflate(R.layout.match_info,null);
        linearLayout.addView(v);
      }
    }
  }
}
