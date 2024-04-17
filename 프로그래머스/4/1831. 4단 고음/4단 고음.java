class Solution {
    static int answer;
    public int solution(int n) {
        answer = 0;
        solve(n-2, 2);
        return answer;
    }
    
    private static void solve(int cur, int left){
        if(cur == 3 && left == 2){
            answer++;
            return;
        }
        if(cur<3) return;
        if(cur>Integer.MAX_VALUE/4){
            int cnt = 1;
            long num = 3;
            long cur2 = cur;
            while(true){
                if(num>cur2) break;
                num*=3;
                cnt++;
            }
            if((cnt-1)*2<left) return;
        }
        else{
            int cnt = 1;
            int num = 3;
            while(true){
                if(num>cur) break;
                num*=3;
                cnt++;
            }
            if((cnt-1)*2<left) return;
        }
        
        if(cur%3==0 && left>=2){
            solve(cur/3, left-2);
        }
        solve(cur-1, left+1);
    }
}