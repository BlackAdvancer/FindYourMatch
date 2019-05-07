package yuheng.personal.findyourmatch.model;

public class Participant extends Player {
    int participantId;
    int teamId;
    int championId;
    String rank;
    ParticipantStat participantStat;

    public Participant(String summonerName, String summonerId, String accountId, int profileIronId, int participantId) {
        super(summonerName, summonerId, accountId, profileIronId);
        this.participantId = participantId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public ParticipantStat getParticipantStat() {
        return participantStat;
    }

    public void setParticipantStat(ParticipantStat participantStat) {
        this.participantStat = participantStat;
    }

    public MatchInfo getMatchInfo(){
        return new MatchInfo(super.getSummonerName(),
                championId,
                participantStat.champLevel,
                participantStat.kills,
                participantStat.deaths,
                participantStat.assists,
                participantStat.items,
                participantStat.win);
    }

    @Override
    public String toString() {
        return "\nParticipant ID: " + participantId +
                "\nTeam ID: " + teamId +
                "\nChampion ID: " + championId +
                "\nRank: " + rank + participantStat.toString();
    }
}
