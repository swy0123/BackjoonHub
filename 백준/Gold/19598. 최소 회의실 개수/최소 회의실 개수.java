import java.util.*;
import java.io.*;

public class Main {
	static class node{
		int start, end;
		public node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		
		PriorityQueue<node> startQ = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<node> endQ = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.end - o2.end;
			}
		});
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 int start = Integer.parseInt(st.nextToken());
			 int end = Integer.parseInt(st.nextToken());
			 startQ.add(new node(start, end));
		}
		
		while(!startQ.isEmpty()) {
			node cn = startQ.poll();
			if(endQ.isEmpty()) {
				endQ.add(cn);
			}
			else {
				if(cn.start<endQ.peek().end) {
					endQ.add(cn);
					max = Math.max(max, endQ.size());
				}
				else {
					startQ.add(cn);
					max = Math.max(max, endQ.size());
					if(!endQ.isEmpty()) {
						 endQ.poll();
					}
					else {
						return;
					}
				}
			}
		}
		System.out.println(max);
	}

}