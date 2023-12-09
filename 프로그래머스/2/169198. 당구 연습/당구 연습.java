class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++){
            int min = 10000000;
            if(startX==balls[i][0]){
                if(startY>balls[i][1]){
                    min = Math.min(min, (2*n-startY-balls[i][1])*(2*n-startY-balls[i][1]));
                }
                else{
                    min = Math.min(min, (startY+balls[i][1])*(startY+balls[i][1]));
                }
                min = Math.min(min, (startY-balls[i][1])*(startY-balls[i][1])+(startX+balls[i][0])*(startX+balls[i][0]));
                min = Math.min(min, (startY-balls[i][1])*(startY-balls[i][1])+(2*m-startX-balls[i][0])*(2*m-startX-balls[i][0]));
                // System.out.println("1: "+min);
            }
            else if(startY==balls[i][1]){
                if(startX>balls[i][0]){
                    min = Math.min(min, (2*m-startX-balls[i][0])*(2*m-startX-balls[i][0]));
                }
                else{
                    min = Math.min(min, (startX+balls[i][0])*(startX+balls[i][0]));
                }
                min = Math.min(min, (startX-balls[i][0])*(startX-balls[i][0])+(startY+balls[i][1])*(startY+balls[i][1]));
                min = Math.min(min, (startX-balls[i][0])*(startX-balls[i][0])+(2*n-startY-balls[i][1])*(2*n-startY-balls[i][1]));
                // System.out.println("2: "+min);
            }
            else{
                min = Math.min(min, (startY-balls[i][1])*(startY-balls[i][1])+(startX+balls[i][0])*(startX+balls[i][0]));
                min = Math.min(min, (startY-balls[i][1])*(startY-balls[i][1])+(2*m-startX-balls[i][0])*(2*m-startX-balls[i][0]));
                min = Math.min(min, (startX-balls[i][0])*(startX-balls[i][0])+(startY+balls[i][1])*(startY+balls[i][1]));
                min = Math.min(min, (startX-balls[i][0])*(startX-balls[i][0])+(2*n-startY-balls[i][1])*(2*n-startY-balls[i][1]));
            }
            answer[i] = min;
            // System.out.println("---");
        }
        return answer;
    }
}