import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int n, max, map[][], dist[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        max = 0;
        
        map = new int[n][n];
        dist = new int[n][n];
        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                dfs(y, x);
            }
        }
        System.out.println(max);
    }
    private static int dfs(int y, int x) {
    	if(dist[y][x] != 0) {
    		return dist[y][x];
    	}
    	dist[y][x] = 1;
    	for(int d=0; d<4; d++) {
    		int cy = di[d]+y;
    		int cx = dj[d]+x;
    		if(cy >= 0 && cy < n && cx >= 0 && cx < n) {
    			if(map[y][x] < map[cy][cx]) {
    				dist[y][x] = Math.max(dist[y][x], dfs(cy, cx) + 1);
    			}
    		}
    	}
		max = Math.max(max, dist[y][x]);
    	return dist[y][x];
    }

}