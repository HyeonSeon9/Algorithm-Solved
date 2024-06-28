class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int answer = health;
        
        int endTime = attacks[attacks.length-1][0];
        
        int count = 0;
        int attackTime = 0;
        for(int i=1;i<=endTime;i++){
            if(i==attacks[attackTime][0]){
                answer -=attacks[attackTime++][1];
                
                count=0;
            }else{
                count++;
                if(count==bandage[0]){
                    answer+=bandage[2];
                    count=0;
                }
                answer+=bandage[1];
                if(answer>health){
                    answer=health;
                }
            }
            if(answer<=0){
                return -1;
            }
        }
        System.out.println(answer);
        return answer<=0?-1:answer;
    }
}