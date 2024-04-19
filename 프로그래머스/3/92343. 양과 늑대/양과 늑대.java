import java.util.*;
class Solution {
    static class node{
        int idx, prev, sheepCnt, wolfCnt;
        boolean isSheep;
        boolean[] v;
        ArrayList<Integer> nexts = new ArrayList();
        public node(int idx, boolean isSheep, int sheepCnt, int wolfCnt){
            this.idx = idx;
            this.isSheep = isSheep;
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
        }
        @Override
        public String toString(){
            return this.idx+" : "+this.isSheep+" "+this.prev+" "+nexts.toString();
        }
    }
    static node[] arr;
    static int max, ret;
    static boolean[] v;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        arr = new node[info.length];
        max = 0;
        ret = 0;
        for(int i=0; i<info.length; i++){
            arr[i] = new node(i, info[i]==0?true:false, 0, 0);
            arr[i].v = new boolean[info.length];
            if(info[i]==0) max++;
        }
        for(int[] edge:edges){
            int prev = edge[0];
            int next = edge[1];
            arr[prev].nexts.add(next);
            arr[next].prev = prev;
        }
        solve(0);
        
        // for(int i=0; i<arr.length; i++){
        //     System.out.println(arr[i].toString());
        // }        
        answer = ret;
        return answer;
    }
    private static void solve(int root){
        ArrayDeque<node> q = new ArrayDeque();
        arr[root].sheepCnt++;
        ret = 1;
        q.add(arr[root]);
        arr[root].v[root] = true;
        
        while(!q.isEmpty()){
            node cn = q.poll();
            for(int ni:cn.nexts){
                node next = new node(ni, arr[ni].isSheep, cn.sheepCnt, cn.wolfCnt);
                next.v = cn.v.clone();
                next.prev = arr[ni].prev;
                next.nexts = arr[ni].nexts;
                
                if(!next.v[ni]){
                    if(next.isSheep){
                        next.v[ni] = true;
                        next.idx = 0;
                        next.sheepCnt++;
                        next.prev = arr[root].prev;
                        next.nexts = arr[root].nexts;
                        ret = Math.max(ret, next.sheepCnt);
                        q.add(next);
                        // System.out.println("ss"+ni);
                        // System.out.println(next.toString());
                        break;
                    }
                    else{
                        if(next.sheepCnt<=next.wolfCnt+1) continue;
                        next.v[ni] = true;
                        next.wolfCnt++;
                    }
                }
                q.addLast(next);
                // System.out.println(Arrays.toString(next.v));
            }
        }
    }
}