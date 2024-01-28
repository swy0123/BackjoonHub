import java.util.*;
import java.io.*;

public class Main {
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int map[][], n, m, check[][], cnt;
	static boolean[][] v;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        v = new boolean[n][m];
        check = new int[n][m];
        cnt = 0;
        for(int i=0; i<n; i++) {
        	String str = br.readLine();
        	for(int j=0; j<m; j++) {
        		if(str.charAt(j) == 'U') {
        			map[i][j] = 0;
        		}
        		else if(str.charAt(j) == 'D') {
        			map[i][j] = 1;
        		}
        		else if(str.charAt(j) == 'L') {
        			map[i][j] = 2;
        		}
        		else if(str.charAt(j) == 'R') {
        			map[i][j] = 3;
        		}
        	}
        }
        int num = 1;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(!v[i][j]) solve(i, j, num++);
        	}
        }
        System.out.println(cnt);
    }
    
    private static void solve(int i, int j, int num) {
    	int ni = i+di[map[i][j]];
    	int nj = j+dj[map[i][j]];
    	v[i][j] = true;
    	check[i][j] = num;
    	if(!v[ni][nj]) {
    		solve(ni, nj, num);
		}
		else if(check[ni][nj] == num){
			cnt++;
		}
    	
    }
}