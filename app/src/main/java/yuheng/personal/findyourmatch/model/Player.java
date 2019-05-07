package yuheng.personal.findyourmatch.model;

public abstract class Player {
    private String summonerName;
    private String summonerId;
    private String accountId;
    private int profileIronId;

    public Player(){}

    public Player(String summonerName, String summonerId, String accountId, int profileIronId){
        this.summonerName = summonerName;
        this.summonerId = summonerId;
        this.accountId = accountId;
        this.profileIronId = profileIronId;
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

    public int getProfileIronId() {
        return profileIronId;
    }

    public void setProfileIronId(int profileIronId) {
        this.profileIronId = profileIronId;
    }

    public String toString(){
        return "SummonerName: " + summonerName +
                "\nSummonerId: " + summonerId +
                "\nAccountId: " + accountId +
                "\nProfileIronId: " + profileIronId + "\n";
    }
}
