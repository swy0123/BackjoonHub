import java.lang.*;
import java.util.*;

class Solution {
    static class node{
        int x, y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] di = {-1, 1, 0 ,0};
    static int[] dj = {0 ,0, -1, 1};
    static int[][] v;
    static int n, m;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        v = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(v[i], -1);
        }
        ArrayList<Integer> size = new ArrayList();
        int idx = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1 && v[i][j]==-1){
                    size.add(solve(idx, land, j, i));
                    idx++;
                }
            }
        }
        int max = 0;
        System.out.println(idx);
        boolean[] check;
        for(int j=0; j<m; j++){
            check = new boolean[idx];
            int tmp = 0;
            for(int i=0; i<n; i++){
                if(v[i][j]!=-1){
                    check[v[i][j]] = true;
                }
            }
            for(int t=0; t<idx; t++){
                if(check[t]) tmp += size.get(t);
            }
            max = Math.max(max, tmp);
        }
        
        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(v[i]));
        // }
        // System.out.println(max);
        return max;
    }
    
    private static int solve(int idx, int[][] map, int x, int y){
        Queue<node> q = new ArrayDeque();
        v[y][x] = idx;
        q.add(new node(x, y));
        int cnt = 1;
        
        while(!q.isEmpty()){
            node cn = q.poll();
            
            for(int d=0; d<4; d++){
                int ni = cn.y+di[d];
                int nj = cn.x+dj[d];
                if(ni>=0 && ni<n && nj>=0 && nj<m && v[ni][nj]==-1 && map[ni][nj]==1){
                    cnt++;
                    v[ni][nj] = idx;
                    q.add(new node(nj, ni));
                }
            }
        }
        return cnt;
    }
}