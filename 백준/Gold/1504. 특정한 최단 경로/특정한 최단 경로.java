import java.io.*;
import java.util.*;

public class Main {
	private static class node implements Comparable<node> {
		int to;
		int cost;

		node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(node o) {
			return this.cost - o.cost;
		}
	}

	private static final int INF = 200000000;
	private static int n;
	private static ArrayList<node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new node(b, c));
			graph[b].add(new node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long route1 = (long) dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
		long route2 = (long) dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
		long answer = Math.min(route1, route2);

		if (answer >= INF)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<node> pq = new PriorityQueue();
		pq.add(new node(start, 0));

		while (!pq.isEmpty()) {
			node cn = pq.poll();
			if (cn.cost != dist[cn.to])
				continue;
			if (cn.to == end)
				return cn.cost;

			for (node next : graph[cn.to]) {
				if (dist[next.to] <= cn.cost + next.cost)
					continue;
				dist[next.to] = cn.cost + next.cost;
				pq.add(new node(next.to, dist[next.to]));

			}
		}
		return INF;
	}
}
