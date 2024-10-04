import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class node {
		int x, y, cnt;
		public node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[n][n];
    	boolean[][] v = new boolean[n][n];
    	int[] res = new int[m];
    	
    	st = new StringTokenizer(br.readLine());
    	int sx = Integer.parseInt(st.nextToken())-1;
    	int sy = Integer.parseInt(st.nextToken())-1;
    	
    	int cx, cy;
    	for(int i=1; i<=m; i++) {
    		st = new StringTokenizer(br.readLine());
    		cx = Integer.parseInt(st.nextToken())-1;
    		cy = Integer.parseInt(st.nextToken())-1;
    		
    		map[cy][cx] = i;
    	}
    	
    	ArrayDeque<node> q = new ArrayDeque<>();
    	v[sy][sx] = true;
    	q.add(new node(sx, sy, 0));
    	
    	while(!q.isEmpty()) {
    		node cn = q.pop();
    		
    		for(int d=0; d<8; d++) {
    			int nx = cn.x + dx[d];
    			int ny = cn.y + dy[d];
    			
    			if(nx>=0 && nx<n && ny>=0 && ny<n && !v[ny][nx]) {
    				v[ny][nx] = true;
    				if(map[ny][nx] != 0) res[map[ny][nx]-1] = cn.cnt+1;
    				q.add(new node(nx, ny, cn.cnt+1));
    			}
    		}
    	}
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<m; i++) {
    		sb.append(res[i]+" ");
    	}
    	
    	System.out.println(sb);
    }
}