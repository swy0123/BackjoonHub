import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int n, m, map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int y=0; y<n; y++) {
        	st = new StringTokenizer(br.readLine());
        	for(int x=0; x<m; x++) {
        		map[y][x] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int cnt = 0;
        boolean flag = false;
        while(!isDevided()) {
        	cnt++;
        	boolean[][] v = new boolean[n][m];
        	boolean finish = true;
        	for(int y=0; y<n; y++) {
        		for(int x=0; x<m; x++) {
        			if(map[y][x]>0) {
        				finish = false;
        				v[y][x] = true;
        				for(int d=0; d<4; d++) {
        					if(map[y][x] == 0) break;
        					int ny = y+dy[d];
        					int nx = x+dx[d];
        					if(ny>=0 && ny<n && nx>=0 && nx<m && !v[ny][nx] && map[ny][nx]==0) {
        						map[y][x]--;
        					}
        				}
        			}
        		}
        	}
//        	for(int i=0; i<n; i++) {
//        		System.out.println(Arrays.toString(map[i]));
//        	}
//            System.out.println(cnt);
        	if(finish) {
        		flag = true;
        		break;
        	}
        }
        if(flag) System.out.println(0);
        else System.out.println(cnt);
    }
    
    private static boolean isDevided() {
    	//2차원 방문배열 생성
    	boolean[][] visited = new boolean[n][m];
    	//boolean flag 생성
    	boolean flag = false;
    	//2차원 배열 탐색
    	for(int y=0; y<n; y++) {
    		for(int x=0; x<m; x++) {
    			if(visited[y][x]) continue;
    	    	//0이 아닌 원소 만나면 bfs 후 방문체크 & flag toggle
    			if(map[y][x] != 0) {
    				if(flag) return true;
    		    	//flag가 토글된 상태로 0이 아닌 원소 만나면 return true;
    				flag = true;
    				Queue<Node> q = new ArrayDeque<>();
    				q.add(new Node(y, x));
    				visited[y][x] = true;
    				while(!q.isEmpty()) {
    					Node cn = q.poll();
    					for(int d=0; d<4; d++) {
    						int ny = cn.y+dy[d];
    						int nx = cn.x+dx[d];
    						if(ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx] && map[ny][nx]>0) {
    							visited[ny][nx] = true;
    							q.add(new Node(ny, nx));
    						}
    					}
    				}
    			}
    		}
    	}
    	return false;
    }

}