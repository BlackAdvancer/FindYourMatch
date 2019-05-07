package yuheng.personal.findyourmatch.providers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static yuheng.personal.findyourmatch.providers.ApiKey.API_KEY;

public class MatchProvider extends AbstractHttpDataProvider{
    private long gameId;

    public MatchProvider(){
        super();
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String web = "https://na1.api.riotgames.com/lol/match/v4/matches/" + gameId+"?api_key="+API_KEY;
        return new URL(web);
    }

    @Override
    public byte[] dataSourceToBytes() throws IOException {
        return new byte[0];
    }

}
