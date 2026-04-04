import java.io.*;
import java.util.*;

public class Main {
	private static class node implements Comparable<node>{
		int to;
		int dist;
		node(int to, int dist){
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(node o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		ArrayList<node>[] arr = new ArrayList[v+1];
		for(int i=1; i<=v; i++) arr[i] = new ArrayList();
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new node(b, c));
		}
		
		int[] dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		
		PriorityQueue<node> pq = new PriorityQueue();
		pq.add(new node(start, 0));
		
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(cn.dist != dist[cn.to]) continue;
			
			for(node next : arr[cn.to]) {
				if(dist[next.to] <= next.dist + cn.dist) continue;
				dist[next.to] = next.dist + cn.dist;
				pq.add(new node(next.to, dist[next.to]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(dist[i]);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
