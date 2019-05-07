package yuheng.personal.findyourmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import yuheng.personal.findyourmatch.model.Summoner;
import yuheng.personal.findyourmatch.model.SummonerManager;

public class MainActivity extends AppCompatActivity {
  private SummonerManager summonerManager = SummonerManager.getInstance();
  String name;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = findViewById(R.id.button1);
    EditText editText = findViewById(R.id.editText1);
    name = editText.getText().toString();
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openSummonerPage();
      }
    });
  }

  public void openSummonerPage() {
    System.out.println(name);
    Summoner summoner = summonerManager.getSummoner(name);
    Intent intent = new Intent(this,SummonerPage.class);
    intent.putExtra("Summoner",summoner);
    startActivity(intent);
  }

}
