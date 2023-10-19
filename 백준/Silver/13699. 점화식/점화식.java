import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        arr[0] = 1;
        for(int i=1; i<=n; i++) {
        	long cur = 0;
        	for(int j=0; j<i; j++) {
        		cur += arr[i-j-1]*arr[j];
        	}
        	arr[i] = cur;
        }
        System.out.println(arr[n]);
    }
}