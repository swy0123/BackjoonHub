import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[n];
        int max = 0;
        for(int i=0; i<n; i++) {
        	dp[i] = arr[i];
        	for(int j=0; j<n; j++) {
        		if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i]) dp[i] = dp[j]+arr[i];
        	}
        	if(max<dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}