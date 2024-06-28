import java.util.*;
class Solution {    
    public String[] solution(String[] players, String[] callings) {
        
        Map<String,Integer> ranking = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            ranking.put(players[i],i);
        }
        
        for(String player : callings){
            int rank = ranking.get(player);
            String frontPlayer = players[rank-1];
            
            ranking.put(frontPlayer,rank);
            players[rank-1]=player;
            
            ranking.put(player,rank-1);
            players[rank]=frontPlayer;
            
            
            
        }
        
         
        
        return players;
    }
}