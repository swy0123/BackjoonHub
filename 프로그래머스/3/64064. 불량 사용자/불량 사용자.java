import java.util.*;
class Solution {
    static String[] user, banned;
    static int answer, n, m;
    static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        m = banned_id.length;
        user = user_id.clone();
        banned = banned_id.clone();
        set = new HashSet();
        solve(0, new boolean[n]);
        return set.size();
    }
    private static void solve(int depth, boolean[] v){
        if(depth == m){
            String ret = "";
            for(boolean cur:v){
                if(cur) ret+="1";
                else ret+="0";
            }
            set.add(ret);
            return;
        }
        
        L: for(int i=0; i<n; i++){
            String str = user[i];
            if(v[i]) continue;
            if(str.length()!=banned[depth].length()) continue;
            for(int j=0; j<str.length(); j++){
                if(banned[depth].charAt(j)=='*') continue;
                if(str.charAt(j)!=banned[depth].charAt(j)) continue L;
            }
            v[i] = true;
            solve(depth+1, v);
            v[i] = false;
        }
        
    }
}