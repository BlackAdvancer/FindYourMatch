package yuheng.personal.findyourmatch;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import yuheng.personal.findyourmatch.model.Summoner;
import yuheng.personal.findyourmatch.model.SummonerManager;

public class MainActivity extends AppCompatActivity {
  private SummonerManager summonerManager = SummonerManager.getInstance();
  Intent intent;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openSummonerPage();
      }
    });
  }

  public void openSummonerPage() {
    EditText editText = findViewById(R.id.editText1);
    String name = editText.getText().toString();
    System.out.println(name);
    intent = new Intent(this,SummonerPage.class);
    new findSummoner().execute(name);

    //Summoner summoner = summonerManager.getSummoner(name);
    //summoner.toString();
    //Intent intent = new Intent(this,SummonerPage.class);
    //intent.putExtra("Summoner",summoner);
    //startActivity(intent);
  }

  public class findSummoner extends AsyncTask<String,Integer,Summoner >{

    @Override
    protected Summoner doInBackground(String... params) {
      return summonerManager.getSummoner(params[0]);
    }

    @Override
    protected void onPostExecute(Summoner s) {
      super.onPostExecute(s);
      intent.putExtra("Summoner",s);
      startActivity(intent);
    }
  }

}
