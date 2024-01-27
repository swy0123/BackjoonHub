import java.util.*;
import java.io.*;

public class Main {
	static class node implements Comparable<node>{
		int start, end;
		public node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(node o) {
			return this.end-o.end!= 0 ? this.end-o.end : this.start-o.start;
		}
//		@Override
//		public String toString() {
//			return this.start+" "+this.end;
//		}
	}
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        node[] arr = new node[n];
        int start, end;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	start = Integer.parseInt(st.nextToken());
        	end = Integer.parseInt(st.nextToken());
        	
        	arr[i] = new node(start, end);
        }
        Arrays.sort(arr);
        int cnt = 0, cur = 0;
        for(int i=0; i<n; i++) {
        	if(arr[i].start>=cur) {
        		cnt++;
        		cur = arr[i].end;
        	}
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}