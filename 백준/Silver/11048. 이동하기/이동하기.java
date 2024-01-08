import java.lang.*;
import java.io.*;
import java.util.*;

// 이동하기 11048
public class Main {
//	private static class node{
//		int i, j;
//		public node(int i, int j) {
//			this.i = i;
//			this.j = j;
//		}
//	}
	static int N, M;
	static int[][] map;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        int[][] res = new int[N][M];
        res[0][0] = map[0][0];
        if(N>1) {
        	for(int i=1; i<N; i++) {
        		res[i][0] = res[i-1][0]+map[i][0];
        	}
        }
        if(M>1) {
        	for(int j=1; j<M; j++) {
        		res[0][j] += res[0][j-1]+map[0][j];
        	}
        }
        for(int i=1; i<N; i++) {
        	for(int j=1; j<M; j++) {
        		res[i][j] = Math.max(res[i-1][j]+map[i][j], res[i][j-1]+map[i][j]);
        	}
        }
//        for(int i=0; i<N; i++) {
//        	System.out.println(Arrays.toString(res[i]));
//        }
        System.out.println(res[N-1][M-1]);
    }
}