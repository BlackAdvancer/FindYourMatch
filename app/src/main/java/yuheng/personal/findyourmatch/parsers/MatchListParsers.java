package yuheng.personal.findyourmatch.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import yuheng.personal.findyourmatch.providers.MatchListProvider;

public class MatchListParsers {
    private MatchListProvider matchListProvider;

    public MatchListParsers(){
        matchListProvider = new MatchListProvider();
    }

    public long[] ParseMatchList(String accountId){
        long[] matches = new long[10];
        try {
            matchListProvider.setAccountId(accountId);
            JSONObject jo = new JSONObject(matchListProvider.dataSourceToString());
            JSONArray match = jo.getJSONArray("matches");
            for (int i = 0; i < 10; i++) {
                JSONObject mo = match.getJSONObject(i);
                long gameId = mo.getLong("gameId");
               matches[i] = gameId;
            }
            return matches;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
