class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int fir = 0, sec = 0;
        boolean[] isFin = new boolean[2];
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j)=='O') fir++;
                if(board[i].charAt(j)=='X') sec++;
            }
            if((board[i].charAt(0)=='O' && board[i].charAt(1)=='O' && board[i].charAt(2)=='O')||
               (board[0].charAt(i)=='O' && board[1].charAt(i)=='O' && board[2].charAt(i)=='O')){
                isFin[0] = true;
            }
            if((board[i].charAt(0)=='X' && board[i].charAt(1)=='X' && board[i].charAt(2)=='X')||
               (board[0].charAt(i)=='X' && board[1].charAt(i)=='X' && board[2].charAt(i)=='X')){
                isFin[1] = true;
            }
        }
        if((board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2))||
           (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0))){
            if(board[1].charAt(1)=='O') isFin[0] = true;
            else isFin[1] = true;
        }
        if(sec>fir || fir>sec+1) return 0;
        if(isFin[0] && fir == sec) return 0;
        if(isFin[1] && fir != sec) return 0;
        
        return 1;
    }
}