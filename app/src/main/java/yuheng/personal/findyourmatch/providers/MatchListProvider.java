package yuheng.personal.findyourmatch.providers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static yuheng.personal.findyourmatch.providers.ApiKey.API_KEY;

public class MatchListProvider extends AbstractHttpDataProvider {
    private String accountId;

    public MatchListProvider(){
        super();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    protected URL getURL() throws MalformedURLException{
        String web = "https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId+"?api_key="+API_KEY;
        return new URL(web);
    }

    @Override
    public byte[] dataSourceToBytes() throws IOException {
        return new byte[0];
    }
}
