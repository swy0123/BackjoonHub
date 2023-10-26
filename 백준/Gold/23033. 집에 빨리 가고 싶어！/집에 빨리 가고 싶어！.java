import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int cur, time;
		public Node(int cur, int time) {
			this.cur = cur;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
		
	}
	
	static class Route{
		int to, time, w;
		public Route(int to, int time, int w) {
			this.to = to;
			this.time = time;
			this.w = w;
		}
	}
	static ArrayList<Route>[] arr;
	static int n, m, dist[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        dist = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i] = new ArrayList<>();
        	dist[i] = Integer.MAX_VALUE;
        }
        int from, to, time, w;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	time = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	arr[from].add(new Route(to, time, w));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
        	Node cn = pq.poll();
        	if(dist[cn.cur] < cn.time) continue;
        	
        	for (Route next : arr[cn.cur]) {
				if(cn.time % next.w == 0) {
					if(dist[next.to]>cn.time+next.time) {
						dist[next.to] = cn.time+next.time;
						pq.add(new Node(next.to, dist[next.to]));
					}
				}
				else {
					int tmp = 0;
					for(int i=1; i<10; i++) {
						if((cn.time+i) % next.w == 0) {
							if(dist[next.to]>cn.time+i+next.time) {
								dist[next.to] = cn.time+i+next.time;
								pq.add(new Node(next.to, dist[next.to]));
							}
							break;
						}
					}
				}
			}
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[n]);
    }
}