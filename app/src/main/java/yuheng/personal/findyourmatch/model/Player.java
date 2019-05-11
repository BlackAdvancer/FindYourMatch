package yuheng.personal.findyourmatch.model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Player implements Parcelable {
    private String summonerName;
    private String summonerId;
    private String accountId;
    private int profileIconId;

    public Player(){}

    public Player(String summonerName, String summonerId, String accountId, int profileIronId){
        this.summonerName = summonerName;
        this.summonerId = summonerId;
        this.accountId = accountId;
        this.profileIconId = profileIronId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String toString(){
        return "SummonerName: " + summonerName +
                "\nSummonerId: " + summonerId +
                "\nAccountId: " + accountId +
                "\nProfileIronId: " + profileIconId + "\n";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(summonerName);
        dest.writeString(summonerId);
        dest.writeString(accountId);
        dest.writeInt(profileIconId);
    }
}
