class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int len = schedules.length;
        int[] limits = new int[len];
        for(int i=0; i<len; i++){
            limits[i] = schedules[i]+10;
            if(limits[i]%100 >= 60){
                limits[i] = (limits[i]/100 + 1)*100 + limits[i]%100-60;
            }
        }
        // startday = 1일 때, 6,7 즉 5,6번째 skip
        // startday = 2일 때, 5,6 즉 4,5번째 skip
        // startday = 3일 때, 5,6 즉 3,4번째 skip
    
        for(int i=0; i<len; i++){
            boolean pass = true;
            for(int j=0; j<7; j++){
                if(j==7-startday || j==7-startday-1) continue;
                if(startday==7 && j==6) continue;
                if(limits[i]<timelogs[i][j]) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
        }
        
        return answer;
    }
}