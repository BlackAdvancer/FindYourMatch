package yuheng.personal.findyourmatch.model;

import android.os.Parcel;

public class Participant extends Player{
    int participantId;
    int teamId;
    int championId;
    String rank;
    ParticipantStat participantStat;

    public Participant(String summonerName, String summonerId, String accountId, int profileIronId, int participantId) {
        super(summonerName, summonerId, accountId, profileIronId);
        this.participantId = participantId;
    }

    protected Participant(Parcel in) {
        super(in.readString(),in.readString(),in.readString(),in.readInt());
        participantId = in.readInt();
        teamId = in.readInt();
        championId = in.readInt();
        rank = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(participantId);
        dest.writeInt(teamId);
        dest.writeInt(championId);
        dest.writeString(rank);
    }

    public static final Creator<Participant> CREATOR = new Creator<Participant>() {
        @Override
        public Participant createFromParcel(Parcel in) {
            return new Participant(in);
        }

        @Override
        public Participant[] newArray(int size) {
            return new Participant[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }
}
