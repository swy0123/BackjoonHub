import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class node{
		int i, j, dir, cnt;

		public node(int i, int j, int dir, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int w, h, min;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new char[h][w];
		
		int si = -1, sj = -1;
		for(int i=0; i<h; i++) {
			String str = br.readLine();
			for(int j=0; j<w; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'C') {
					si = i;
					sj = j;
				}
			}
		}
		min = Integer.MAX_VALUE;
		bfs(si, sj);
		System.out.println(min);

	}
	
	private static void bfs(int si, int sj) {
		Queue<node> q = new LinkedList<>();
		int[][] v = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		q.add(new node(si, sj, 5, 0));
		v[si][sj] = 0;
		while(!q.isEmpty()) {
			node cn = q.poll();
			for(int d=0; d<4; d++) {
				int ci = cn.i+di[d];
				int cj = cn.j+dj[d];
				if(ci>=0 && ci<h && cj>=0 && cj<w && v[ci][cj]>cn.cnt) {
					if (map[ci][cj]=='.') {
						if(cn.dir==5) {
							v[ci][cj] = 0;
							q.add(new node(ci, cj, d, 0));
						}
						else if(cn.dir == d) {
							v[ci][cj] = cn.cnt;
							q.add(new node(ci, cj, d, cn.cnt));
						}
						else {
							v[ci][cj] = cn.cnt+1;
							q.add(new node(ci, cj, d, cn.cnt+1));
						}
					}
					else if(map[ci][cj]=='C') {
						if(cn.dir == d) {
							v[ci][cj] = cn.cnt;
							min = Math.min(min, v[ci][cj]);
						}
						else {
							v[ci][cj] = cn.cnt+1;
							min = Math.min(min, v[ci][cj]);
						}
					}
				}
			}
		}
		
		
		
		
	}

}