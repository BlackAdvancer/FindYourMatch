package yuheng.personal.findyourmatch.model;



import java.util.HashMap;
import java.util.Map;

import yuheng.personal.findyourmatch.parsers.MatchParsers;

public class MatchManager {
    private static MatchManager instance;
    private Map<Long,Match> matchMap;
    private MatchParsers matchParsers;

    private MatchManager(){
        this.matchMap = new HashMap<>();
        this.matchParsers = new MatchParsers();
    }

    public static MatchManager getInstance(){
        if(instance == null)
            instance = new MatchManager();
        return instance;
    }

    public Match getMatch(long gameId){
        Match m = matchMap.get(gameId);
        if(m != null)
            return m;
        m = matchParsers.ParseMatch(gameId);
        matchMap.put(gameId,m);
        return  m;
    }

    public MatchInfo[] getMatches(String summonerName, long[] gameId){
        MatchInfo[] matchInfos = new MatchInfo[gameId.length];
        for(int i = 0 ; i < matchInfos.length; i++){
            matchInfos[i] = getMatch(gameId[i]).getMatchInfo(summonerName);
        }
        return matchInfos;
    }
}
