import java.io.*;
import java.util.*;

public class Main {
	static int n, max1 = 0, max2 = 0;
	 public static void main(String args[]) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 n = Integer.parseInt(br.readLine());
		 boolean[][] map = new boolean[n][n];
		 
		 for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<n; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			 }
		 }
		 
		 boolean[][] odd = new boolean[n][n];
		 boolean[][] even = new boolean[n][n];
		 
		 for(int i=0; i<n; i++) {
			 odd[i] = map[i].clone();
			 even[i] = map[i].clone();
		 }
		 
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if((i+j) % 2 == 0) {
					 odd[i][j] = false;
				 }
				 else even[i][j] = false;
			 }
		 }
		 
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(map[i][j]) {
					 map[i][j] = false;
					 if((i+j) % 2 == 0) solve(i, j, even, 1, true);
					 else solve(i, j, odd, 1, false);
					 map[i][j] = true;
				 }
			 }
		 }
		 
		 System.out.println(max1+max2);
	 }
	 
	 public static void solve(int si, int sj, boolean[][] prev, int cnt, boolean isEven) {
//		 if(max<cnt) {
//			 System.out.prbooleanln(cnt+ "-----");
//			 for(boolean i=0; i<n; i++) {
//				 System.out.prbooleanln(Arrays.toString(prev[i]));
//			 }
//		 }
		 if(isEven)	max1 = Math.max(max1, cnt);
		 else max2 = Math.max(max2, cnt);
		 if(max1+max2>=18) return;
		 
		 boolean[][] cur = new boolean[n][n];
		 for(int i=0; i<n; i++) {
			 cur[i] = prev[i].clone();
		 }
		 // 지도 복사해서 못놓는 곳 표시하고 
		 for(int t=0; t<n-si; t++) {
			 if(sj-t>=0) cur[si+t][sj-t] = false;
			 if(sj+t<n) cur[si+t][sj+t] = false;
		 }
		 
		 // 다음 좌표, 표시된 지도, cnt+1로 백트래킹
		 for(int i=si; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 if(i==si && j<=sj) continue;
				 if(cur[i][j]) {
					 cur[i][j] = false;
					 solve(i, j, cur, cnt+1, isEven);
					 cur[i][j] = true;
				 }
			 }
		 }
	 }
}