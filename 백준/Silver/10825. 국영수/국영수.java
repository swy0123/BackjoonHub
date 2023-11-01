import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		String name;
		int ko, en, ma;
		public Node(String name, int ko, int en, int ma) {
			this.name = name;
			this.ko = ko;
			this.en = en;
			this.ma = ma;
		}

		@Override
		public int compareTo(Node o) {
			if(this.ko!=o.ko) return o.ko-this.ko;
			if(this.en!=o.en) return this.en-o.en;
			if(this.ma!=o.ma) return o.ma-this.ma;
			return this.name.compareTo(o.name);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int ma = Integer.parseInt(st.nextToken());
			arr[i] = new Node(name, ko, en, ma);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(Node item:arr) {
			sb.append(item.name+"\n");
		}
		System.out.println(sb);
	}
}