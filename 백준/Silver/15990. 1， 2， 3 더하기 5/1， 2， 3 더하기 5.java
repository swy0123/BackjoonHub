import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n, size = 4, input[] = new int[t];
        long dp[][];
        for(int i=0; i<t; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        	size = Math.max(size, input[i])+1;
        }
        
        dp = new long[size][3];
        dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;
        dp[1][0] = 1; dp[1][1] = 0; dp[1][2] = 0;
        dp[2][0] = 0; dp[2][1] = 1; dp[2][2] = 0;
        dp[3][0] = 1; dp[3][1] = 1; dp[3][2] = 1;
        
        for(int i=4; i<size; i++) {
        	dp[i][0] = (dp[i-1][1] + dp[i-1][2])%1000000009;
        	dp[i][1] = (dp[i-2][0] + dp[i-2][2])%1000000009;
        	dp[i][2] = (dp[i-3][0] + dp[i-3][1])%1000000009;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
        	n = input[i];
        	sb.append(((dp[n][0]+dp[n][1]+dp[n][2])%1000000009)+"\n");
        }
    	System.out.println(sb);
    }
}