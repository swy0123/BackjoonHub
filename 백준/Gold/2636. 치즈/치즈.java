import java.io.*;
import java.util.*;

public class Main {
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	int r = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	    	
	    	int[][] map = new int[r][c];
	    	
	    	for(int i=0; i<r; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		for(int j=0; j<c; j++) {
	    			map[i][j] = Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	int time = 0;
	    	int last = 0;
	    	boolean[][] visited;
	    	Queue<int[]> q = new ArrayDeque<>();
	    	Queue<int[]> melt = new ArrayDeque<>();
	    	int cy, cx;
	    	while(true) {
	    		visited = new boolean[r][c];
	    		q.offer(new int[] {0, 0});
	    		visited[0][0] = true;
	    		
	    		while(!q.isEmpty()) {
	    			int[] cur = q.poll();
	    			for(int d=0; d<4; d++) {
	    				cy = cur[0] + dy[d];
	    				cx = cur[1] + dx[d];
	    				if(cy<0 || cy>=r || cx<0 || cx>=c || visited[cy][cx]) continue;
	    				visited[cy][cx] = true;
	    				if(map[cy][cx] == 1) melt.offer(new int[] {cy, cx});
	    				else q.offer(new int[] {cy, cx});
	    			}
	    		}
	    		
	    		if(melt.isEmpty()) {
	    			break;
	    		}
	    		last = melt.size();
	    		time++;
	    		while(!melt.isEmpty()) {
	    			int[] cur = melt.poll();
	    			map[cur[0]][cur[1]] = 0;
	    		}
	    	}
	    	
	    	System.out.println(time);
	    	System.out.println(last);
    }
}
