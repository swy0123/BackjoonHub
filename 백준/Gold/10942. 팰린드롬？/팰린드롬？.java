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
        
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++) dp[i][i] = true;

        for(int i=0; i<n-1; i++) {
        	if(arr[i]==arr[i+1]) dp[i][i+1]= true;
        }

        for(int i=2; i<n; i++){
            for(int j=0; j<n-i; j++){
                if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start, end;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken())-1;

            if(dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }
}