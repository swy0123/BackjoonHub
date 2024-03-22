import java.lang.*;
import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        L: for(int i=0; i<numbers.length; i++){
            String str = Long.toBinaryString(numbers[i]);
            for(int t=0; t<str.length(); t++){
                if((str.length()+t)%2==0){
                    continue;
                }
                if(check(("0".repeat(t))+str)){
                    answer[i] = 1;
                    continue L;
                }
            }
            answer[i] = 0;
            
        }
        return answer;
    }
    private static boolean check(String str){
        if(str.length()==0) return false;
        if(str.length()==1 && str.charAt(0)=='1') return true;
        String next = "";
        int idx = 0;
        boolean[] v = new boolean[str.length()];
        for(int i=0; i<str.length(); i+=2){
            if(v[i]) {
                if(i+1<str.length()) next+=str.charAt(i+1);
                else break;
                continue;
            }
            if(i+2>=str.length()) return false;
            v[i] = true;
            v[i+2] = true;
            if(str.charAt(i)=='0' && str.charAt(i+2)=='0' && str.charAt(i+1)=='0') next+="0";
            else {
                next+="1";
                if(str.charAt(i+1)=='0') return false;
            }
            idx++;
        }
        return check(next);
    }
    
}

