package yuheng.personal.findyourmatch.model;



public class Match {
    String platformId;
    String gameMode;
    String gameType;
    int mapId;
    long gameId;
    long gameDuration;
    long gameCreation;
    Team blurTeam;
    Team redTeam;
    Participant[] participants;

    public Match(String platformId, String gameMode, String gameType, int mapId, long gameId, long gameDuration, long gameCreation, Team blurTeam, Team redTeam, Participant[] participants) {
        this.platformId = platformId;
        this.gameMode = gameMode;
        this.gameType = gameType;
        this.mapId = mapId;
        this.gameId = gameId;
        this.gameDuration = gameDuration;
        this.gameCreation = gameCreation;
        this.blurTeam = blurTeam;
        this.redTeam = redTeam;
        this.participants = participants;
    }

    public MatchInfo getMatchInfo(String summonerName){
        MatchInfo matchInfo = null;
        for(Participant p : participants) {
            if (summonerName.equals(p.getSummonerName())) {
                matchInfo = p.getMatchInfo();
                matchInfo.setMapId(mapId);
                matchInfo.setGameMode(gameMode);
                matchInfo.setGameType(gameType);
                matchInfo.setGameCreation(gameCreation);
                matchInfo.setGameId(gameId);
                break;
            }
        }
        return matchInfo;
    }

    @Override
    public String toString() {
        String temp;
        temp =  "Match{" +
                "platformId='" + platformId + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", gameType='" + gameType + '\'' +
                ", mapId=" + mapId +
                ", gameDuration=" + gameDuration +
                ", gameCreation=" + gameCreation +
                '}' + "\nBlue Team: " + blurTeam.toString() +
                "\nred Team: " + redTeam.toString();
        StringBuilder sb = new StringBuilder(temp);
        for (Participant p : participants)
            sb.append(p.toString());
        return  sb.toString();
    }
}
