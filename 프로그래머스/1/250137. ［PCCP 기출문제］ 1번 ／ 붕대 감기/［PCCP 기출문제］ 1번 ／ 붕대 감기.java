import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int answer = health;
        int last = 0;
        
        int v1,v2;
        for(int[] atk : attacks){
            if(answer<=0){
                return -1;
            }
            
            v1=atk[0]-last-1;
            v2=v1/bandage[0];
            
            last = atk[0];
            
            answer = Math.min(health,answer +(bandage[1]*v1));
            answer = Math.min(health,answer +(bandage[2]*v2));
            
            answer-=atk[1];
        }
        
        return answer<=0?-1:answer;
    }
}