package yuheng.personal.findyourmatch.model;

public class Team {
    int teamId;
    int towerKills;
    int dragonKills;
    boolean win;

    public Team(int teamId, int towerKills, int dragonKills, boolean win) {
        this.teamId = teamId;
        this.towerKills = towerKills;
        this.dragonKills = dragonKills;
        this.win = win;
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", towerKills=" + towerKills +
                ", dragonKills=" + dragonKills +
                ", win=" + win +
                '}';
    }
}
