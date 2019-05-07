package yuheng.personal.findyourmatch.parsers;


import org.json.JSONObject;
import yuheng.personal.findyourmatch.model.Summoner;
import yuheng.personal.findyourmatch.providers.SummonerProvider;

public class SummonerParsers {
    private SummonerProvider summonerProvider;
    private MatchListParsers matchListParsers;

    public SummonerParsers(){
        summonerProvider = new SummonerProvider();
        matchListParsers = new MatchListParsers() ;
    }

    public Summoner ParseSummoner(String name) {
        //TODO: name format needs to be checked.
        try {
            summonerProvider.setName(name);
            JSONObject jo = new JSONObject(summonerProvider.dataSourceToString());
            int profileIconId =jo.getInt("profileIconId");
            String summonerName = jo.getString("name");
            int summonerLevel = jo.getInt("summonerLevel");
            String accountId = jo.getString("accountId");
            String summonerId = jo.getString("id");
            Summoner summoner = new Summoner(summonerName,summonerId,accountId,profileIconId,summonerLevel);
            summoner.setMatchesList(matchListParsers.ParseMatchList(accountId));
            return summoner;
        }catch (Exception e){
            System.err.println("Error in Summoner Parser parsing "+ name + e.getMessage());
        }
        return null;
    }
}
