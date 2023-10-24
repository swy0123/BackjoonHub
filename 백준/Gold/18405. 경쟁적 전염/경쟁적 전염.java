import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int y, x, type, cnt;
		public Node(int y, int x, int type, int cnt) {
			this.y = y;
			this.x = x;
			this.type = type;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return this.type-o.type;
		}
	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int n, m, ty, tx, s, map[][];
	static ArrayList<Node> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        arr = new ArrayList<>();
        for(int y=0; y<n; y++) {
        	st = new StringTokenizer(br.readLine());
        	for(int x=0; x<n; x++) {
            	map[y][x] = Integer.parseInt(st.nextToken());
            	if(map[y][x]!=0) {
            		arr.add(new Node(y, x, map[y][x], 0));
            	}
        	}
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken())-1;
        tx = Integer.parseInt(st.nextToken())-1;
        Collections.sort(arr);
//        for (Node item : arr) {
//			System.out.println(item.type);
//		}
        Queue<Node> q = new ArrayDeque<>();
        for (Node item : arr) {
        	q.add(item);
		}
        while(!q.isEmpty()) {
        	Node cn = q.poll();
        	if(cn.cnt==s) break;
        	
        	for(int d=0; d<4; d++) {
        		int ny = cn.y+dy[d];
        		int nx = cn.x+dx[d];
        		if(ny>=0 && ny<n && nx>=0 && nx<n && map[ny][nx]==0) {
        			map[ny][nx] = cn.type;
        			q.add(new Node(ny, nx, cn.type, cn.cnt+1));
        		}
        	}
//        	for(int i=0; i<n; i++) {
//        		System.out.println(Arrays.toString(map[i]));
//        	}
//        	System.out.println(cn.cnt);
        }
        System.out.println(map[ty][tx]);
    }
}