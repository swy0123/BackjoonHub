import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class item{
		long m, v;

		public item(long m, long v) {
			super();
			this.m = m;
			this.v = v;
		}
//		@Override
//		public String toString() {
//			return this.m + " " + this.v;
//		}
	}

	static int n, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		long answer = 0;
		
		long m, v;
		List<item> arr = new ArrayList();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			arr.add(new item(m, v));
		}
		Collections.sort(arr, (a, b) ->Long.compare(a.m, b.m));
		
//		for(int i=0; i<n; i++) {
//			System.out.println(arr.get(i).toString());
//		}
		
		int[] bag = new int[k];
		for(int i=0; i<k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		PriorityQueue<Long> pq = new PriorityQueue<>((a, b)->Long.compare(b, a));
		int idx = 0;
		for(int i=0; i<k; i++) {
			while(idx<n && bag[i]>=arr.get(idx).m) {
				pq.add(arr.get(idx++).v);
			}
			if(pq.isEmpty()) continue;
			answer += pq.poll();
		}
		
		
		System.out.println(answer);
	}
}