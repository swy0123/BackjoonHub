import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] map = new int[n][2];
        int max = arr[0];
        map[0][0] = arr[0];
        map[0][1] = arr[0];
        for(int i=1; i<n; i++) {
        	if(map[i-1][0]+arr[i]>arr[i]) {
        		map[i][0] = map[i-1][0]+arr[i];
        	}
        	else {
        		map[i][0] = arr[i];
        	}
        	
        	if(map[i-1][1]+arr[i]<map[i-1][0]) {
        		map[i][1] = map[i-1][0];
        	}
        	else {
        		map[i][1] = map[i-1][1]+arr[i];
        	}
        	max = Math.max(max, map[i][1]);
        	max = Math.max(max, map[i][0]);
        }
        System.out.println(max);
    }
}