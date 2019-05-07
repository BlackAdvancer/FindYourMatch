package yuheng.personal.findyourmatch.model;


import java.util.HashMap;
import java.util.Map;

import yuheng.personal.findyourmatch.parsers.SummonerParsers;

public class SummonerManager {
    private static SummonerManager instance;
    private Map<String, Summoner> summonerMap;
    private SummonerParsers summonerParsers;

    private SummonerManager(){
        this.summonerMap = new HashMap<>();
        this.summonerParsers = new SummonerParsers();
    }

    public static SummonerManager getInstance(){
        if(instance == null)
            instance = new SummonerManager();
        return instance;
    }

    public Summoner getSummoner(String name){
        Summoner s = summonerMap.get(name);
        if(s != null)
            return s;
        s = summonerParsers.ParseSummoner(name);
        summonerMap.put(name,s);
        return s;
    }

}
