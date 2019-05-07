package yuheng.personal.findyourmatch.model;



public class ParticipantStat {
    int kills;
    int deaths;
    int assists;
    int goldEarned;
    int totalMinionsKilled;
    int champLevel;
    int[] items;
    boolean win;

    public ParticipantStat(int kills, int deaths, int assists, int goldEarned, int totalMinionsKilled, int champLevel, int[] items, boolean win) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.goldEarned = goldEarned;
        this.totalMinionsKilled = totalMinionsKilled;
        this.champLevel = champLevel;
        this.items = items;
        this.win = win;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public int[] getItems() {
        return items;
    }

    @Override
    public String toString(){
        String temp;
        temp =  "\nKills: " + kills +
                "\nDeaths: " + deaths +
                "\nAssists: " + assists +
                "\nGold Earned: " + goldEarned +
                "\nCS: " + totalMinionsKilled +
                "\nChampion Level: " + champLevel;
        StringBuilder sb = new StringBuilder(temp);
        for (int i = 0; i < 7; i++) {
            temp = "\nitem" + i + ": " + items[i];
            sb.append(temp);
        }
        sb.append("\n");
        return sb.toString();
    }
}
