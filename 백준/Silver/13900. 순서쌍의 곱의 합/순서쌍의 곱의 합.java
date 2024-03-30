import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long sum = 0L, ret = 0L;
        for(int i=0; i<n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        	sum += arr[i];
        }
        for(int i=0; i<n; i++) {
        	ret += (sum-arr[i])*arr[i];
        	sum -= arr[i];
        }
        System.out.println(ret);
    }
}