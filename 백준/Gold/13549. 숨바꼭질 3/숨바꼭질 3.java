import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 1697 숨바꼭질
 */
public class Main {    
	static class node {
        int idx, time;
        
        public node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static int n, m, min = Integer.MAX_VALUE;
    static boolean[] v;
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        v = new boolean[100001];
        bfs();
        System.out.println(min);
    }
    
    public static void bfs() {
        Queue<node> q = new LinkedList<>();
        q.offer(new node(n, 0));
        
        while(!q.isEmpty()) {
            node cn = q.poll();
            v[cn.idx] = true;
            if(cn.idx == m) min = Math.min(min, cn.time);
            
            if(cn.idx*2 < v.length && !v[cn.idx*2]) q.offer(new node(cn.idx*2, cn.time));
            if(cn.idx+1 < v.length && !v[cn.idx+1]) q.offer(new node(cn.idx+1, cn.time+1));
            if(cn.idx-1 >= 0 && !v[cn.idx-1]) q.offer(new node(cn.idx-1, cn.time+1));
        }
    }
}