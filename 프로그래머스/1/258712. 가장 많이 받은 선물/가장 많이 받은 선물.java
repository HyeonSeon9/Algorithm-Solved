import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String,Integer>> giftRecords = new HashMap<>();
        Map<String,Integer> giftScore = new HashMap<>();
        Map<String,Integer> nextMonthGift = new HashMap<>();
        
        Arrays.stream(friends).forEach(friend -> {
            giftRecords.put(friend,new HashMap());
            giftScore.put(friend,0);
            nextMonthGift.put(friend,0);
        });
        
        Arrays.stream(gifts).forEach(gift -> {
            String[] split = gift.split(" ");
            String sender = split[0];
            String receiver = split[1];
            
            giftRecords.get(sender).put(receiver,giftRecords.get(sender).getOrDefault(receiver,0)+1);
            giftScore.put(sender,giftScore.get(sender)+1);
            giftScore.put(receiver,giftScore.get(receiver)-1);
            
        });
        
        
        
        for(String sender : friends){
            for(String receiver : friends){
                if(!sender.equals(receiver)){
                    Integer sendTo = giftRecords.get(sender).getOrDefault(receiver,0);
                    Integer recevierTo = giftRecords.get(receiver).getOrDefault(sender,0);
                    
                    if(sendTo>recevierTo){
                        nextMonthGift.put(sender,nextMonthGift.get(sender)+1);
                    }else if(sendTo==recevierTo && giftScore.get(sender)>giftScore.get(receiver)){
                        nextMonthGift.put(sender,nextMonthGift.get(sender)+1);
                    }
                }
            }
        }
        
    
        
        
        return Collections.max(nextMonthGift.values());
    }
}