package yuheng.personal.findyourmatch.model;



import android.os.Parcel;
import android.os.Parcelable;



public class Summoner extends Player implements Parcelable {
    long[] matchesList;
    int summonerLevel;

    public Summoner(String summonerName, String summonerId, String accountId, int profileIronId,int summonerLevel){
        super(summonerName,summonerId,accountId,profileIronId);
        this.summonerLevel = summonerLevel;
    }

    protected Summoner(Parcel in) {
        super(in.readString(),in.readString(),in.readString(),in.readInt());
        matchesList = in.createLongArray();
        summonerLevel = in.readInt();

    }

    public static final Creator<Summoner> CREATOR = new Creator<Summoner>() {
        @Override
        public Summoner createFromParcel(Parcel in) {
            return new Summoner(in);
        }

        @Override
        public Summoner[] newArray(int size) {
            return new Summoner[size];
        }
    };

    public void setMatchesList(long[] matchesList) {
        this.matchesList = matchesList;
    }

    public long[] getMatchesList() {
        return matchesList;
    }

    @Override
    public String toString() {
        StringBuilder reString = new StringBuilder( super.toString() + "SummonerLevel: " + summonerLevel);
        for(long i : matchesList) {
            reString.append("\nMatchId: ");
            reString.append(i);
        }
        reString.append("\n");
        return reString.toString();
    }

    public int getSummonerLevel(){
        return this.summonerLevel;
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        dest.writeLongArray(matchesList);
        dest.writeInt(summonerLevel);
    }
}
