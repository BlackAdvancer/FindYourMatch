package yuheng.personal.findyourmatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuheng.personal.findyourmatch.model.Summoner;

public class SummonerPage extends AppCompatActivity {
  Summoner summoner;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_summoner_page);
    summoner = (Summoner) getIntent().getExtras().get("Summoner");
  }
}
