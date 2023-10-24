import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int y, x, cnt, fish;
		public Node(int y, int x, int cnt, int fish) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.fish = fish;
		}
	}
	static boolean[][][] v;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int n, m, start[];
	static char map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        v = new boolean[n][m][2];
        start = new int[2];
        for(int y=0; y<n; y++) {
        	String str = br.readLine();
        	for(int x=0; x<m; x++) {
        		map[y][x] = str.charAt(x);
        		if(map[y][x] == 'S') {
        			start[0] = y;
        			start[1] = x;
        		}
        	}
        }
        int max = -1;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start[0], start[1], 0, 0));
        v[start[0]][start[1]][0] = true;
        while(!q.isEmpty()) {
        	Node cn = q.poll();

        	int isFish = cn.fish;
        	if(isFish == 1 && map[cn.y][cn.x] == 'H') {
        		max = cn.cnt;
        		break;
        	}
        	if(isFish == 0 && map[cn.y][cn.x] == 'F') {
        		isFish = 1;
        	}
        	for(int d=0; d<4; d++) {
        		int ny = cn.y + dy[d];
        		int nx = cn.x + dx[d];
        		if(ny>=0 && ny<n && nx>=0 && nx<m && map[ny][nx]!='D') {
        			if(isFish == 0 && !v[ny][nx][0]) {
        				v[ny][nx][isFish] = true;
        				q.add(new Node(ny, nx, cn.cnt+1, isFish));
        			}
        			if(isFish == 1 && !v[ny][nx][1]) {
        				v[ny][nx][isFish] = true;
        				q.add(new Node(ny, nx, cn.cnt+1, isFish));
        			}
        		}
        	}
        }
        System.out.println(max);
    }
}