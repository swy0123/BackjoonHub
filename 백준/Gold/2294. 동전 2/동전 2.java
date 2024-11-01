import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=arr[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		if(dp[k] == 100001) {
			System.out.println("-1");
		}
		else System.out.println(dp[k]);

	}

}