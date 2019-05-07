package yuheng.personal.findyourmatch.model;

import java.util.Arrays;

public class MatchInfo {
    String summonerName;
    boolean win;
    int championId;
    int champLevel;
    int kills;
    int deaths;
    int assists;
    int[] items;
    int mapId;
    long gameId;
    long gameCreation;
    String gameMode;
    String gameType;

    public MatchInfo(String summonerName, int championId, int champLevel, int kills, int deaths, int assists, int[] items, boolean win) {
        this.summonerName = summonerName;
        this.championId = championId;
        this.champLevel = champLevel;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.items = items;
        this.win = win;
    }


    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public void setGameCreation(long gameCreation) {
        this.gameCreation = gameCreation;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getGameId() {
        return gameId;
    }

    @Override
    public String toString() {
        return "MatchInfo{" +
                "summonerName='" + summonerName + '\'' +
                ", win=" + win +
                ", championId=" + championId +
                ", champLevel=" + champLevel +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", items=" + Arrays.toString(items) +
                ", mapId=" + mapId +
                ", gameCreation=" + gameCreation +
                ", gameMode='" + gameMode + '\'' +
                ", gameType='" + gameType + '\'' +
                '}';
    }
}
