
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc=0; tc<t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[v+1];
			for (int i = 1; i <= v; i++) {
		        graph[i] = new ArrayList();
		    }
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			int[] visited = new int[v+1];
			boolean pass = true;
			
			for(int i=1; i<=v; i++) {
				if(visited[i] != 0) continue;
				Queue<Integer> q = new ArrayDeque();
				q.add(i);
				visited[i] = 1;
				while(!q.isEmpty()) {
					if(!pass) break;
					int cn = q.poll();
					for(int next: graph[cn]) {
						if(visited[next] == 0) {
							visited[next] = -visited[cn];
							q.add(next);
						}
						else if(visited[next] == visited[cn]) {
							pass = false;
							break;
						}
					}
				}
			}
			sb.append(pass ? "YES" : "NO").append('\n');
		}
		System.out.print(sb);
	}
}
