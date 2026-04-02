import java.io.*;
import java.util.*;

public class Main {
	private static class Road {
		int end;
		int cost;

		Road(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		ArrayList<Road>[] shortcuts = new ArrayList[d + 1];
		for(int i=0; i<=d; i++) shortcuts[i] = new ArrayList<>();

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if(end > d) continue;
			if(end - start <= cost) continue;
			shortcuts[start].add(new Road(end, cost));
		}

		int[] dp = new int[d + 1];
		for(int i=1; i<=d; i++) dp[i] = i;

		for(int i=0; i<=d; i++) {
			if(i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			for(Road road : shortcuts[i]) {
				dp[road.end] = Math.min(dp[road.end], dp[i] + road.cost);
			}
		}

		System.out.println(dp[d]);
	}
}
