import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static int n, m, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		solve(0, new int[m]);
		System.out.println(sb);
	}
	
	private static void solve(int idx, int[] tmp) {
		if(idx==m) {
			StringBuilder s = new StringBuilder();
			for(int i=0; i<tmp.length; i++) {
				s.append(tmp[i]);
				if(i!=tmp.length-1)s.append(' ');
			}
			sb.append(s);
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<n; i++) {
			tmp[idx] = arr[i];
			solve(idx+1, tmp);
		}
	}
}