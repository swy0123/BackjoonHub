import java.lang.*;
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int min = 100;
        ArrayList<Integer>[] arr;
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            arr[from].add(to);
            arr[to].add(from);
        }
        
        for(int i=0; i<wires.length; i++){
            boolean[] v = new boolean[n+1];
            Queue<Integer> q = new ArrayDeque();
            int start = wires[i][0];
            v[start] = true;
            v[wires[i][1]] = true;
            int cnt = 1;
            q.add(start);
            while(!q.isEmpty()){
                int cn = q.poll();
                for(int j=0; j<arr[cn].size(); j++){
                    int next = arr[cn].get(j);
                    if(!v[next]){
                        v[next] = true;
                        cnt++;
                        q.add(next);
                    }
                }
            }
            min = Math.min(Math.abs((n-cnt)-cnt), min);
        }
        if(min != 100) answer = min;
        return answer;
    }
}