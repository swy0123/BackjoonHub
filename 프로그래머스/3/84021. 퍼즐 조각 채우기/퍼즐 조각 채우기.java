import java.util.*;
class Solution {
    static class node implements Comparable<node>{
        int i, j;
        public node(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(node o){
            return this.i == o.i ? this.j-o.j : this.i - o.i;
        }
        
        @Override
        public String toString(){
            return this.i+" "+this.j;
        }
    }
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<ArrayList<node>> arr;
    static ArrayList<ArrayList<node>> blocks;
    static int n, map[][];
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = game_board.length;
        visited = new boolean[n][n];
        arr = new ArrayList();
        blocks = new ArrayList();
        visited = new boolean[n][n];
        map = game_board.clone();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j]==0 && !visited[i][j]){
                    arr.add(find(i, j, 0));
                }
            }
        }
        visited = new boolean[n][n];
        map = table.clone();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(table[i][j]==1 && !visited[i][j]){
                    blocks.add(find(i, j, 1));
                }
            }
        }
        
        System.out.println(arr.toString());
        System.out.println(blocks.toString());
        System.out.println("------");
        
        for(int i=0; i<arr.size(); i++){
            int j=0;
            while(j<blocks.size()){
                if(blocks.get(j).size() == arr.get(i).size()){
                    if(check(blocks.get(j), arr.get(i), j)){
                        System.out.println(j +" "+arr.get(i).size());
                        answer += arr.get(i).size();
                        break;
                    }
                }
                j++;
            }
        }
        
        System.out.println(answer);
        return answer;
    }
    private static boolean check(ArrayList<node> block, ArrayList<node> target, int cur){
        System.out.println("target : "+target.toString());
        System.out.println(block.toString());
        
        int nexti, nextj, maxi = 0, maxj = 0;
        ArrayList<node> tmp = new ArrayList(); 
        ArrayList<node> next;
        for(int idx=0; idx<block.size(); idx++){
            node cn = block.get(idx);
            maxi = Math.max(maxi, cn.i);
            maxj = Math.max(maxj, cn.j);
            tmp.add(new node(cn.i, cn.j));
        }
        //정방형 체크
        boolean flag = true;
        for(int idx=0; idx<tmp.size(); idx++){
            node cn = tmp.get(idx);
            node tn = target.get(idx);
            if(cn.i!=tn.i || cn.j!=tn.j) {
                // System.out.println(cn.i+" : "+tn.i+", "+cn.j+" : "+tn.j);
                flag = false;
                break;
            }
        }
        
        if(flag) {
            System.out.println("pass");
            blocks.remove(cur);
            return true;
        }
        //왼쪽으로 돌면서 체크
        for(int turn=0; turn<3; turn++){
            flag = true;
            nexti = 0;
            nextj = 0;
            next = new ArrayList();
            for(int idx=0; idx<tmp.size(); idx++){
                node cn = tmp.get(idx);
                nexti = Math.max(nexti, cn.i);
                nextj = Math.max(nextj, cn.j);
            }
            for(int idx=0; idx<tmp.size(); idx++){
                node cn = tmp.get(idx);
                next.add(new node(nextj-cn.j, cn.i));
            }
            maxi = nexti;
            maxj = nextj;
            Collections.sort(next);
            System.out.println(next.toString());
            System.out.println(maxi+" : "+maxj+", "+nexti+" : "+nextj);
            for(int idx=0; idx<next.size(); idx++){
                node cn = next.get(idx);
                node tn = target.get(idx);
                if(cn.i!=tn.i || cn.j!=tn.j) {
                    // System.out.println(cn.i+" : "+tn.i+", "+cn.j+" : "+tn.j);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("pass");
                blocks.remove(cur);
                return true;
            }
            tmp = next;
        }
        return false;
    }
    
    private static ArrayList<node> find(int i, int j, int type){
        int mini = i, minj = j;
        ArrayList<node> tmp = new ArrayList();
        ArrayList<node> ret = new ArrayList();
        Queue<node> q = new ArrayDeque();
        boolean[][] v = new boolean[n][n];
        v[i][j] = true;
        q.add(new node(i, j));
        while(!q.isEmpty()){
            node cn = q.poll();
            visited[cn.i][cn.j] = true;
            tmp.add(cn);
            mini = Math.min(mini, cn.i);
            minj = Math.min(minj, cn.j);
            int ni, nj;
            for(int d=0; d<4; d++){
                ni = cn.i+di[d];
                nj = cn.j+dj[d];
                if(ni>=0 && ni<n && nj>=0 && nj<n && !v[ni][nj] && map[ni][nj]==type){
                    v[ni][nj] = true;
                    q.add(new node(ni, nj));
                }
            }
        }
        for(int t=0; t<tmp.size(); t++){
            node cn = tmp.get(t);
            ret.add(new node(cn.i-mini, cn.j-minj));
        }
        Collections.sort(ret);
        return ret;
    }
}