import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class point{
		int i, j, score;

		public point(int i, int j, int score) {
			super();
			this.i = i;
			this.j = j;
			this.score = score;
		}
	}
	
	//19, 4, 2
	static int[][][] shape = {
			{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
			
			{{0, 0}, {1, 0}, {0, 1}, {1, 1}},
			
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
			{{0, 0}, {1, 0}, {2, 0}, {2, -1}},
			{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
			{{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}},
			{{0, 0}, {0, -1}, {0, -2}, {1, -2}},
			{{0, 0}, {0, -1}, {0, -2}, {-1, -2}},
			
			{{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
			{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
			{{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},
			{{0, 0}, {-1, 0}, {-1, -1}, {-2, -1}},
			
			{{0, 0}, {0, 1}, {-1, 1}, {0, 2}},
			{{0, 0}, {0, 1}, {1, 1}, {0, 2}},
			{{0, 0}, {1, 0}, {1, 1}, {2, 0}},
			{{0, 0}, {1, 0}, {1, -1}, {2, 0}}
	};
	
	static int n, m, max, maxVal;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxVal = Math.max(maxVal, map[i][j]);
			}
		}
		
		max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(max >= map[i][j] + maxVal * 3) continue;
				for(int t=0; t<shape.length; t++) {
					int tmp = 0;
					for(int d=0; d<4; d++) {
						int ci=i+shape[t][d][0];
						int cj=j+shape[t][d][1];
						if(ci>=0 && ci<n && cj>=0 && cj<m) {
							tmp += map[ci][cj];
							if(max >= tmp + maxVal * (3-d)) break;
							if(d==3) {
//								System.out.println(t+" "+i+" "+j+" "+tmp);
								max = Math.max(max, tmp);
							}
						}
						else break;
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
	
//	private static void dfs(int i, int j, int cnt, int sum) {
//		if(max >= sum + max)
//	}

}