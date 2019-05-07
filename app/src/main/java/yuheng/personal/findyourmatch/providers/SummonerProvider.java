package yuheng.personal.findyourmatch.providers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static yuheng.personal.findyourmatch.providers.ApiKey.API_KEY;

public class SummonerProvider extends AbstractHttpDataProvider{
    private String name;

    public SummonerProvider(){
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected URL getURL() throws MalformedURLException{
        String web = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name.replaceAll("\\s","") +"?api_key="+API_KEY;
        return new URL(web);
    }

    @Override
    public byte[] dataSourceToBytes() throws IOException {
        return new byte[0];
    }
}
