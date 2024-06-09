import java.util.*;
import java.io.*;

public class Main {
	static class node {
		int next, cnt;
		public node(int next, int cnt) {
			this.next = next;
			this.cnt = cnt;
		}
	}
	static ArrayList<Integer>[] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        int from, to;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	arr[from].add(to);
        	arr[to].add(from);
        }
        for(int i=1; i<=n; i++) {
        	Collections.sort(arr[i]);
        }
        
        st = new StringTokenizer(br.readLine());
    	from = Integer.parseInt(st.nextToken());
    	to = Integer.parseInt(st.nextToken());
        
        ArrayDeque<node> q = new ArrayDeque<>();
        int[] v = new int[n+1];
        v[from] = -1;
        
        int cnt = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        
        q.add(new node(from, 0));
        while(!q.isEmpty()) {
        	node cn = q.poll();
        	
        	if(cn.next==to) {
        		cnt = cn.cnt;
        		int tmp = cn.next;
        		while(tmp != -1) {
        			visited.add(tmp);
        			tmp = v[tmp];
        		}
        		break;
        	}
        	
        	for(int next:arr[cn.next]) {
        		if(v[next] != 0) continue;
        		q.add(new node(next, cn.cnt+1));
        		v[next] = cn.next;
        	}
        }
//        System.out.println(cnt);
//        System.out.println(visited.toString());
        
        q = new ArrayDeque<>();
        v = new int[n+1];
        for(int num:visited) {
        	v[num] = -2;
        }
        v[from] = 0;
        q.add(new node(to, cnt));
        
        while(!q.isEmpty()) {
        	node cn = q.poll();
        	
        	if(cn.next==from) {
        		cnt = cn.cnt;
        		break;
        	}
        	for(int next:arr[cn.next]) {
        		if(v[next] != 0) continue;
        		q.add(new node(next, cn.cnt+1));
        		v[next] = cn.next;
        	}
        }
        System.out.println(cnt);
    }
}