package yuheng.personal.findyourmatch.parsers;

import yuheng.personal.findyourmatch.model.Match;
import yuheng.personal.findyourmatch.model.Participant;
import yuheng.personal.findyourmatch.model.ParticipantStat;
import yuheng.personal.findyourmatch.model.Team;
import yuheng.personal.findyourmatch.providers.MatchProvider;
import org.json.JSONArray;
import org.json.JSONObject;


public class MatchParsers {
    private MatchProvider matchProvider;

    public MatchParsers() {matchProvider = new MatchProvider();}

    public Match ParseMatch(long gameId){

        matchProvider.setGameId(gameId);
        Match match = null;
        Team blueTeam = null;
        Team redTeam = null;
        Participant[] participantsList = new Participant[10];

        try {
            JSONObject jo = new JSONObject(matchProvider.dataSourceToString());
            JSONArray participantIdentities = jo.getJSONArray("participantIdentities");
            for(int i = 0; i < participantIdentities.length(); i++){
                JSONObject po = participantIdentities.getJSONObject(i);
                JSONObject player = po.getJSONObject("player");
                participantsList[i] = new Participant( player.getString("summonerName"),
                        player.getString("summonerId"),
                        player.getString("accountId"),
                        player.getInt("profileIcon"),
                        po.getInt("participantId"));
            }

            JSONArray teams = jo.getJSONArray("teams");
            for(int i = 0; i < teams.length(); i++){
                boolean win = false;
                JSONObject to = teams.getJSONObject(i);
                if(to.getString("win").equals("Win"))
                    win = true;

                Team team = new Team(to.getInt("teamId"),
                        to.getInt("towerKills"),
                        to.getInt("dragonKills"),
                        win);
                if(team.getTeamId() == 100)
                    blueTeam = team;
                else
                    redTeam = team;
            }


            JSONArray participants = jo.getJSONArray("participants");
            for(int i = 0; i < participants.length(); i++){
                String highestAchievedSeasonTier;
                JSONObject po = participants.getJSONObject(i);
                try{
                    highestAchievedSeasonTier = po.getString("highestAchievedSeasonTier");
                }catch(Exception e){
                    highestAchievedSeasonTier = "Not ranked";
                }

                int[] items = new int[7];
                JSONObject so = po.getJSONObject("stats");
                items[0] = so.getInt("item0");
                items[1] = so.getInt("item1");
                items[2] = so.getInt("item2");
                items[3] = so.getInt("item3");
                items[4] = so.getInt("item4");
                items[5] = so.getInt("item5");
                items[6] = so.getInt("item6");
                ParticipantStat participantStat = new ParticipantStat(so.getInt("kills"),
                        so.getInt("deaths"),
                        so.getInt("assists"),
                        so.getInt("goldEarned"),
                        so.getInt("totalMinionsKilled"),
                        so.getInt("champLevel"),
                        items,
                        so.getBoolean("win"));

                participantsList[i].setTeamId(po.getInt("teamId"));
                participantsList[i].setChampionId(po.getInt("championId"));
                participantsList[i].setRank(highestAchievedSeasonTier);
                participantsList[i].setParticipantStat(participantStat);

            }

            match = new Match(jo.getString("platformId"),
                    jo.getString("gameMode"),
                    jo.getString("gameType"),
                    jo.getInt("mapId"),
                    jo.getLong("gameId"),
                    jo.getLong("gameDuration"),
                    jo.getLong("gameCreation"),
                    blueTeam,
                    redTeam,
                    participantsList);
        }catch (Exception e) {
            System.err.println("Error in Match Parser parsing: " + gameId + e.getMessage());
        }

        return match;
    }
}
