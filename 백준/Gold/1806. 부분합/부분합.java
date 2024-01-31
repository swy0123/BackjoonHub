import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int[] input = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        	if(input[i]==s) {
        		System.out.println(1);
        		System.exit(0);
        	}
        }
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = input[0];
        for(int i=2; i<=n; i++) {
        	arr[i] = arr[i-1]+input[i-1];
        }
//        System.out.println(Arrays.toString(arr));
        
        int start = 0, end = 0, min = 100000001;
        while(start<=n && end<=n) {
//        	System.out.println(start+" "+end+" "+(arr[end]-arr[start]));
        	if(arr[end]-arr[start]<s) end++;
        	else {
        		min = Math.min(min, end-start);
        		start++;
        		if(start>end)end++;
        	}
        }
//        if(arr[end]-arr[start]>=s) min = Math.min(min, end-start);
        if(min>100000000) System.out.println(0);
        else System.out.println(min);
    }
}