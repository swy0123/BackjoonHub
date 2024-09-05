import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        long max = 0;
    	int x = m/2;
    	for(int i=n-1; i>=n-x; i--)max+=a[i];
    	for(int i=0; i<x; i++)max-=a[i];
    	if(m%2==0) max+=a[x-1];
    	else max+=a[n-x-1];
        System.out.println(max);
    }
}