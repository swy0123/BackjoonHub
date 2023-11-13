import java.util.*;

class Solution {
    static class Node{
        int i, j, cnt;
        boolean flag;
        public Node(int i, int j, int cnt, boolean flag){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        boolean[][][] v = new boolean[n][m][2];
        Queue<Node> q = new ArrayDeque();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S'){
                    q.add(new Node(i, j, 0, false));
                    v[i][j][0] = true;
                }
            }
        }
        int res = -1;
        while(!q.isEmpty()){
            Node cn = q.poll();
            boolean nextFlag = cn.flag;
            if(cn.flag && map[cn.i][cn.j]=='E'){
                res = cn.cnt; 
                break;
            }
            else if(!cn.flag && map[cn.i][cn.j]=='L'){
                nextFlag = true;
            }
            for(int d=0; d<4; d++){
                int ni = cn.i+di[d];
                int nj = cn.j+dj[d];
                if(ni>=0 && ni<n && nj>=0 && nj<m && map[ni][nj]!='X'){
                    if(!nextFlag && !v[ni][nj][0]){
                        v[ni][nj][0] = true;
                        q.add(new  Node(ni, nj, cn.cnt+1, nextFlag));
                    }
                    else if(nextFlag && !v[ni][nj][1]){
                        v[ni][nj][1] = true;
                        q.add(new  Node(ni, nj, cn.cnt+1, nextFlag));
                    }
                }
            }
            
        }
        return res;
    }
}